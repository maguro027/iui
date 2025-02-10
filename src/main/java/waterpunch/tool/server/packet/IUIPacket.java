package waterpunch.tool.server.packet;

import com.google.gson.Gson;
import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIパケットの基底クラスです。
 */
public class IUIPacket {

     @SuppressWarnings("unused")
     private final String title = "iuipacket";

     private final String version;

     /**
      * @param type パケットのタイプ
      * @see 基底クラスのコンストラクタです。
      * @see IUIPacket#IUIPacket(PacketType)
      */
     public IUIPacket() {
          version = Core.getIUIVersion();
     }

     /**
      * @see IUIのバージョンを取得します。
      * @return IUIのバージョン
      */
     public String getVersion() {
          return version;
     }

     public byte[] packetConverter(IUIPacket packet) {
          String json = new Gson().toJson(packet);
          return json.getBytes();
     }
}
