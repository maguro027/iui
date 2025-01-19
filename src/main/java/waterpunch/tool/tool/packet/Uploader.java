package waterpunch.tool.tool.packet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 * @version 1.0
 *  このクラスは、IUIサーバーにデータを送信するためのクラスです。
 *  既存のクラスは概要できなものなので、まるっきり中身を変えても大丈夫です。
 */
public class Uploader {

     public static String IUI_HOST = "localhost";
     public static int IUI_PORT = 7500;
     URI uri;

     public Uploader() throws URISyntaxException {
          uri = new URI("https://" + IUI_HOST + ":" + IUI_PORT);
     }

     public void setHost(String host) {
          IUI_HOST = host;
     }

     public String getHost() {
          return IUI_HOST;
     }

     public void setPort(int port) {
          IUI_PORT = port;
     }

     public int getPort() {
          return IUI_PORT;
     }

     public static void sendIUI(InventoryUserInterface iui) throws IOException {
          // ソケットの作成
          try (Socket socket = new Socket(IUI_HOST, IUI_PORT); OutputStream out = socket.getOutputStream()) {
               String json = new Gson().toJson(iui);
               byte[] bytes = json.getBytes();
               // データの送信
               out.write(bytes);

               out.close();
               socket.close();
          }
     }
}
