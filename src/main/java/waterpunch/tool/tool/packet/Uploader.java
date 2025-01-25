package waterpunch.tool.tool.packet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.google.gson.Gson;

import waterpunch.tool.Core;
import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 * @version 0.1
 *  このクラスは、IUIサーバーにデータを送信するためのクラスです。
 *  既存のクラスは概要できなものなので、まるっきり中身を変えても大丈夫です。
 */
public class Uploader {

     public static void main(String[] args) {
          try {
               sendPacket(new ServerFirstConnect());
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public static byte[] packetConverter(IUIPacket packet) {
          String json = new Gson().toJson(packet);
          byte[] bytes = json.getBytes();
          return bytes;
     }

     public static void sendIUI(InventoryUserInterface iui) throws IOException {
          sendPacket(packetConverter(new IUIUPLoadRequest(iui)));
     }

     private static void sendPacket(byte[] bytes) throws IOException {
          try (Socket socket = new Socket(Core.getHost(), Core.getPort()); OutputStream out = socket.getOutputStream()) {
               out.write(bytes);
               out.close();
               socket.close();
          }
     }

     private static void sendPacket(IUIPacket packet) throws IOException {
          try (Socket socket = new Socket(Core.getHost(), Core.getPort()); OutputStream out = socket.getOutputStream()) {
               out.write(packetConverter(packet));
               out.close();
               socket.close();
          }
     }
}
