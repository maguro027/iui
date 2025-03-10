package waterpunch.tool.server.packet.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

import waterpunch.tool.Core;
import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.server.packet.IUIPacket;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、クライアント用パケットの基底クラスです。
 */
public class ClientPacket extends IUIPacket {

     private ClientPacketType type = ClientPacketType.PING;
     private String pluginName;
     private UUID secretKEY;

     public ClientPacket(ClientPacketType type) {
          super();
          setPacketType(type);
          setPluginName(Core.getPluginName());
     }

     /**
      * @param type パケットのタイプ
      * @see パケットのタイプを指定します。
      */

     public final void setPacketType(ClientPacketType type) {
          this.type = type;
     }

     /**
      * @return パケットのタイプを返します。
      */
     public ClientPacketType getType() {
          return type;
     }

     public String getPluginName() {
          return pluginName;
     }

     public final void setPluginName(String pluginName) {
          this.pluginName = pluginName;
     }

     public UUID getSecretKEY() {
          return secretKEY;
     }

     public void setSecretKEY(UUID secretKEY) {
          this.secretKEY = secretKEY;
     }

     /**
      * @see パケットのタイプを指定します。
      * @param type パケットのタイプ
      */

     public enum ClientPacketType {
          PING,
          IUISERVERRESPONSE,
          IUIServerFastConnect,
          IUIUPLoadRequest,
          IUIDeleteRequest,
          IUIListGetRequest,
          IUIGetRequest,
          IUIItemUPLoadRequest,
          ServerFirstConnect,
     }

     public void sendIUI(InventoryUserInterface iui) throws IOException {
          sendPacket(packetConverter(new IUIUPLoadRequest(iui)));
     }

     public String sendPacket() {
          return send(packetConverter(this));
     }

     public String sendPacket(byte[] bytes) {
          return send(bytes);
     }

     private String send(byte[] bytes) {
          try (Socket socket = new Socket(Core.getHost(), Core.getPort()); OutputStream out = socket.getOutputStream(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
               out.write(bytes);
               out.flush();

               // サーバーからの応答を受信
               return in.readLine();
          } catch (IOException e) {
               return null;
          }
     }
}
