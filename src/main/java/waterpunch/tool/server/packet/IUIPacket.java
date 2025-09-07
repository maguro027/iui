package waterpunch.tool.server.packet;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1 このクラスは、IUIパケットの基底クラスです。
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
          setCreateData();
     }

     public String getCreate() {
          return create;
     }

     public byte[] packetConverter(IUIPacket packet) {
          Gson gson = new GsonBuilder().create();
          // Gson gson = new GsonBuilder().serializeNulls().create();
          String json = gson.toJson(packet);
          return json.getBytes(StandardCharsets.UTF_8);
     }
}
