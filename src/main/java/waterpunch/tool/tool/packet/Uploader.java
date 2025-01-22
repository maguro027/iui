package waterpunch.tool.tool.packet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import waterpunch.tool.Core;
import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 * @version 0.1
 *  このクラスは、IUIサーバーにデータを送信するためのクラスです。
 *  既存のクラスは概要できなものなので、まるっきり中身を変えても大丈夫です。
 */
public class Uploader {

     URI uri;

     public Uploader() throws URISyntaxException {
          uri = new URI("https://" + Core.getHost() + ":" + Core.getPort());
     }

     public static void sendIUI(InventoryUserInterface iui) throws IOException {
          // パケットの作成
          String json = new Gson().toJson(CreatePaket(iui));
          byte[] bytes = json.getBytes();
          // ソケットの作成
          try (Socket socket = new Socket(Core.getHost(), Core.getPort()); OutputStream out = socket.getOutputStream()) {
               out.write(bytes);
               out.close();
               socket.close();
          }
     }

     public static IUIPacket CreatePaket(InventoryUserInterface iui) {
          return new IUIUPLoadRequest(iui);
     }
}
