package waterpunch.tool.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import waterpunch.tool.IUITool;
import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.item.ItemTool;
import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.ClientPacket.ClientPacketType;
import waterpunch.tool.server.packet.client.ServerFirstConnect;
import waterpunch.tool.server.packet.server.errors.BadRequest;
import waterpunch.tool.tool.messeage.ColoredText;
import waterpunch.tool.tool.messeage.Messenger;
import waterpunch.tool.tool.messeage.errorreport.BADPacketErrorReport;

/**
 * @author maguro027
 * @version 0.1
 */
public class IUIServer {

     static final ArrayList<String> connectionServers = new ArrayList<>();
     static final HashMap<String, ArrayList<InventoryUserInterface>> iuis = new HashMap<>();
     static final HashMap<String, ArrayList<IUIItem>> items = new HashMap<>();

     /**
      * サーバーデバック用です。
      */
     public static void main(String[] args) throws IOException {
          int port = 12345; // 待ち受けるポート番号
          ClearMemory();
          ServerSocket serverSocket = new ServerSocket(port);

          System.out.println("ポート" + port + "で接続待ち");

          while (true) {
               try (Socket clientSocket = serverSocket.accept()) {
                    // System.out.println("クライアントからの接続を受け付けました");

                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    // ここで受信したパケットの処理を行う
                    byte[] buffer = new byte[1024];
                    int bytesRead = clientSocket.getInputStream().read(buffer);
                    String receivedData = new String(buffer, 0, bytesRead);
                    try {
                         Gson gson = new Gson();
                         ClientPacket packet = gson.fromJson(receivedData, ClientPacket.class);

                         System.out.println(receivedData);

                         // パケットの解析、プラグインの名前などがデフォルトだとエラーを返します。
                         if (packet.getPluginName().equals("DEFAULT") || packet.getPluginName().isEmpty()) {
                              BadRequest errorPacket = new BadRequest(BadRequest.BadPacketType.BADPluginName);
                              BADPacketErrorReport errorReport = new BADPacketErrorReport(errorPacket, receivedData, clientSocket);
                              out.println(errorReport.encodeLog());
                              clientSocket.close();
                         }
                         if (!packetSwitcher(packet.getType(), receivedData, clientSocket, out)) clientSocket.close();
                    } catch (JsonSyntaxException e) {
                         //TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
                         // ErrorMessenger.UnknownPacketType.getMessage();0
                         clientSocket.close();
                    } catch (Exception e) {
                         //TODO ログシステムの追加、不明なエラーが発生した場合にサーバーログに記録する
                         // ErrorMessenger.UnknownError.getMessage();
                         clientSocket.close();
                    }
                    out.println("responseだよ");
                    // 接続を閉じる
               }
          }
     }

     public static void ClearMemory() {
          connectionServers.clear();
          iuis.clear();
          items.clear();
     }

     public static boolean packetSwitcher(ClientPacketType type, String data, Socket socket, PrintWriter out) {
          Gson gson = new Gson();
          switch (type) {
               case IUIDeleteRequest:
                    break;
               case IUIGetRequest:
                    break;
               case IUIItemUPLoadRequest:
                    break;
               case IUIListGetRequest:
                    break;
               case IUISERVERRESPONSE:
                    break;
               case IUIServerFastConnect:
                    try {
                         ServerFirstConnect serverFirstConnect = gson.fromJson(data, ServerFirstConnect.class);

                         //ConnectionServersにサーバーの名前を追加します。
                         System.out.println(new Messenger("Get ServerFirstConnect... from " + serverFirstConnect.getPluginName()).encodeLog());

                         if (connectionServers.contains(serverFirstConnect.getPluginName())) {
                              System.out.println(new Messenger(serverFirstConnect.getPluginName() + " Registere " + ColoredText.setRED("Failure.")).encodeLog());
                              BadRequest errorPacket = new BadRequest(BadRequest.BadPacketType.ExistingName);
                              BADPacketErrorReport errorReport = new BADPacketErrorReport(errorPacket, data, socket);
                              out.println(errorReport.encodeLog());
                              System.out.println(errorReport.encodeLog());
                              return false;
                         }
                         System.out.println(new Messenger(serverFirstConnect.getPluginName() + " Registere " + ColoredText.setGREEN("Success.")).encodeLog());
                         connectionServers.add(serverFirstConnect.getPluginName());
                         //IUIを登録してます
                         if (!serverFirstConnect.getIUIs().isEmpty()) {
                              for (InventoryUserInterface iui : serverFirstConnect.getIUIs()) {
                                   if (IUITool.checkIUIList(iuis.get(serverFirstConnect.getPluginName()), iui)) {
                                        iuis.put(serverFirstConnect.getPluginName(), serverFirstConnect.getIUIs());
                                   }
                              }
                         }
                         //アイテムを登録してます

                         addIUIItem(serverFirstConnect.getPluginName(), serverFirstConnect.getItems());

                         out.println(true);
                         return true;
                    } catch (JsonSyntaxException e) {
                         // デシリアライズに失敗した場合の処理
                         System.err.println("パケットのデシリアライズに失敗しました: " + e.getMessage());
                    }
                    break;
               case IUIUPLoadRequest:
                    break;
               case PING:
                    break;
               default:
                    break;
          }
          return false;
     }

     public static void addIUIItem(String pluginName, ArrayList<IUIItem> items) {
          //リストが空の場合は処理を行いません。
          if (items.isEmpty()) return;
          //forでリストを分解し、addIUIItemを呼び出します。
          for (IUIItem item : items) {
               addIUIItem(pluginName, item);
          }
     }

     public static void addIUIItem(String pluginName, IUIItem item) {
          //アイテムリストが存在しない場合は新規作成します。
          if (items.get(pluginName) == null) items.put(pluginName, new ArrayList<>());
          if (ItemTool.checkItemList(items.get(pluginName), item)) {
               items.get(pluginName).add(item);
               System.out.println(new Messenger("[" + pluginName + "] " + ColoredText.setGREEN("■") + item.getName()).encodeLog() + " Add");
          } else {
               System.out.println(new Messenger("[" + pluginName + "] " + ColoredText.setYELLOW("■") + item.getName()).encodeLog() + " is Already registered.");
          }
     }
}
