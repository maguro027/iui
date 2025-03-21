package waterpunch.tool.server.packet;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author maguro027
 * @version 0.1 このクラスは、IUIパケットの基底クラスです。
 */
public class IUIPacket {

     @SuppressWarnings("unused")
     private final String title = "IUI";

     private String create;

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

     private void setCreateData() {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          create = sdf.format(new Date());
     }

     public byte[] packetConverter(IUIPacket packet) {
          Gson gson = new GsonBuilder().create();
          // Gson gson = new GsonBuilder().serializeNulls().create();
          String json = gson.toJson(packet);
          return json.getBytes(StandardCharsets.UTF_8);
     }
}
