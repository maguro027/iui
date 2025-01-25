package waterpunch.tool.tool.packet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IUIServer {

     /**
      * デバック用です。
      */
     public static void main(String[] args) throws IOException {
          int port = 12345; // 待ち受けるポート番号
          ServerSocket serverSocket = new ServerSocket(port);

          System.out.println("ポート" + port + "で接続待ち");

          while (true) {
               Socket clientSocket = serverSocket.accept();
               System.out.println("クライアントからの接続を受け付けました");

               // ここで受信したパケットの処理を行う
               // 例:
               byte[] buffer = new byte[1024];
               int bytesRead = clientSocket.getInputStream().read(buffer);
               String receivedData = new String(buffer, 0, bytesRead);
               System.out.println("受信データ: " + receivedData);

               // 接続を閉じる
               clientSocket.close();
          }
     }
}
