package waterpunch.tool.server.packet;

import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1 このクラスは、IUIパケットの基底クラスです。
 */
public class IUIPacket {

     @SuppressWarnings("unused")
     private final String title = "IUI";

     private final String version = Core.getIUIVersion();

     /**
      * @param type パケットのタイプ
      * @see 基底クラスのコンストラクタです。
      * @see IUIPacket#IUIPacket(PacketType)
      */
     public IUIPacket() {
     }

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
