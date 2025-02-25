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
                    System.out.println("クライアントからの接続を受け付けました");
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
                         packetSwitcher(packet.getType(), receivedData, clientSocket, out);
                    } catch (JsonSyntaxException e) {
                         //TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
                         // ErrorMessenger.UnknownPacketType.getMessage();0

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

     public static void packetSwitcher(ClientPacketType type, String data, Socket socket, PrintWriter out) {
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
                         if (connectionServers.contains(serverFirstConnect.getPluginName())) {
                              //既に登録されている場合はエラーを返し、ソケットを閉じます。
                              BadRequest errorPacket = new BadRequest(BadRequest.BadPacketType.ExistingName);
                              BADPacketErrorReport errorReport = new BADPacketErrorReport(errorPacket, data, socket);
                              out.println(errorReport.encodeLog());
                              System.out.println(errorReport.encodeLog());
                              // out.println(new BADPacketErrorReport(socket, data));
                              try {
                                   //ソケット閉じるのエラー起きるって致命的じゃない...?
                                   //発生状況が気になる。
                                   socket.close();
                              } catch (IOException ex) {
                                   System.err.println("ソケットのクローズに失敗しました: " + ex.getMessage());
                              }
                         }
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
                         if (!serverFirstConnect.getItems().isEmpty()) {
                              for (IUIItem item : serverFirstConnect.getItems()) {
                                   if (ItemTool.checkItemList(items.get(serverFirstConnect.getPluginName()), item)) {
                                        items.put(serverFirstConnect.getPluginName(), serverFirstConnect.getItems());
                                   }
                              }
                         }
                         out.println(true);
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
     }
}
