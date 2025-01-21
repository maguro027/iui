package waterpunch.tool.tool.packet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;

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
          // パケットの作成
          String json = new Gson().toJson(CreatePaket(iui));
          byte[] bytes = json.getBytes();
          // ソケットの作成
          try (Socket socket = new Socket(IUI_HOST, IUI_PORT); OutputStream out = socket.getOutputStream()) {
               out.write(bytes);
               out.close();
               socket.close();
          }
     }

     public static IUIPacket CreatePaket(InventoryUserInterface iui) {
          return new IUIUPLoadRequest(iui);
     }
}
