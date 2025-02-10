package waterpunch.tool.server;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import waterpunch.tool.server.packet.IUIPacket;
import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.IUIItemUPLoadRequest;
import waterpunch.tool.tool.messeage.errorreport.BADPacketError;

public class IUIServer {

     /**
      * サーバーデバック用です。
      */
     public static void main(String[] args) throws IOException {
          int port = 12345; // 待ち受けるポート番号
          ServerSocket serverSocket = new ServerSocket(port);

          System.out.println("ポート" + port + "で接続待ち");

          while (true) {
               try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("クライアントからの接続を受け付けました");
                    // ここで受信したパケットの処理を行う
                    byte[] buffer = new byte[1024];
                    int bytesRead = clientSocket.getInputStream().read(buffer);
                    String receivedData = new String(buffer, 0, bytesRead);
                    try {
                         Gson gson = new Gson();
                         ClientPacket Packet = gson.fromJson(receivedData, ClientPacket.class);
                         BADPacketError error = new BADPacketError(clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort(), receivedData);
                         System.out.println(error.encodeLog());

                         if (Packet instanceof IUIItemUPLoadRequest) {}
                    } catch (JsonSyntaxException e) {
                         //TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
                         // ErrorMessenger.UnknownPacketType.getMessage();

                         clientSocket.close();
                    }
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("responseだよ");
                    // 接続を閉じる
               }
          }
     }

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
