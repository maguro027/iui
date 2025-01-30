package waterpunch.tool.server.packet;

import com.google.gson.Gson;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIパケットの基底クラスです。
 */
public class IUIPacket {

     @SuppressWarnings("unused")
     private final String title = "iuipacket";

     private String version = "0.1";

     /**
      * @param type パケットのタイプ
      * @see 基底クラスのコンストラクタです。
      * @see IUIPacket#IUIPacket(PacketType)
      */
     public IUIPacket() {}

     public byte[] packetConverter(IUIPacket packet) {
          String json = new Gson().toJson(packet);
          return json.getBytes();
     }

     public String getVersion() {
          return version;
     }

     public void setVersion(String version) {
          this.version = version;
     }
}
