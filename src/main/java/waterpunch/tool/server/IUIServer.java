package waterpunch.tool.server;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.server.packet.IUIPacket;

/**
 * @author maguro027
 * @version 0.1
 */
public class IUIServer {

     static final HashMap<String, UUID> connectionServers = new HashMap<>();
     static final HashMap<String, ArrayList<InventoryUserInterface>> iuis = new HashMap<>();
     static final HashMap<String, ArrayList<IUIItem>> items = new HashMap<>();

     //     /**
     //       * サーバーデバック用です。
     //       */
     //      public static void main(String[] args) throws IOException {
     //           int port = 12345; // 待ち受けるポート番号
     //           try (ServerSocket serverSocket = new ServerSocket(port)) {
     //                System.out.println("ポート" + port + "で接続待ち");

     //           while (true) {
     //                Socket clientSocket = serverSocket.accept();
     //                System.out.println("クライアントからの接続を受け付けました");

     //                // ここで受信したパケットの処理を行う
     //                byte[] buffer = new byte[1024];
     //                int bytesRead = clientSocket.getInputStream().read(buffer);
     //                String receivedData = new String(buffer, 0, bytesRead);
     //                System.out.println("受信データ: " + receivedData);
     //                System.out.println("送信者のIP: " + clientSocket.getInetAddress().getHostAddress());
     //                System.out.println("送信者のポート: " + clientSocket.getPort());
     //                try {
     //                     Gson gson = new Gson();
     //                     ClientPacket Packet = gson.fromJson(receivedData, ClientPacket.class);
     //                } catch (JsonSyntaxException e) {
     //                     //TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
     //                     // ErrorMessenger.UnknownPacketType.getMessage();

     //                     // BADPacketError error = new BADPacketError(clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort(), receivedData);
     //                     BADPacketErrorReport
     //                     System.out.println(error.encodeLog());
     //                     clientSocket.close();
     //                }

     //                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
     //                out.println("responseだよ");
     //                // 接続を閉じる
     //                clientSocket.close();
     //           }
     //      }

     /**
     * デバッグ用のコードです
     * パケットを解析します。
     * @param packetData パケットのデータ
     * @return パケットのデータを解析した結果です、失敗した場合はnullを返します。
     */

     public IUIPacket Packetanalysis(byte[] packetData) {
          try {
               Gson gson = new Gson();
               return gson.fromJson(new String(packetData), IUIPacket.class);
          } catch (JsonSyntaxException e) {
               return null;
          }
     }
}
