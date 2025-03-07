package waterpunch.tool.server.packet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.charset.StandardCharsets;
import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIパケットの基底クラスです。
 */
public class IUIPacket {

     @SuppressWarnings("unused")
     private final String title = "IUI";

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
          Gson gson = new GsonBuilder().create();
          // Gson gson = new GsonBuilder().serializeNulls().create();
          String json = gson.toJson(packet);
          return json.getBytes(StandardCharsets.UTF_8);
     }
}
