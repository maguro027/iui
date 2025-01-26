package waterpunch.tool.tool.packet;

import java.io.IOException;
import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIサーバーに飛ばすパケットの基底クラスです。
 */
public class IUIPacket extends PacketSender {

     @SuppressWarnings("unused")
     private final String title = "iuipacket";

     private PacketType type;

     private final String pluginName;

     /**
      * @param type パケットのタイプ
      * @see 基底クラスのコンストラクタです。
      * @see IUIPacket#IUIPacket(PacketType)
      */
     public IUIPacket(PacketType type) {
          pluginName = Core.getPluginName();
          setPacketType(type);
     }

     public String sendPacket() {
          try {
               return sendPacket(this);
          } catch (IOException e) {
               return null;
          }
     }

     /**
      * @return プラグインの名前を返します。
      */

     public String getPluginName() {
          return pluginName;
     }

     /**
      * @param type パケットのタイプ
      * @see パケットのタイプを指定します。
      */

     public final void setPacketType(PacketType type) {
          this.type = type;
     }

     /**
      * @return パケットのタイプを返します。
      */
     public PacketType getType() {
          return type;
     }

     /**
      * @see パケットのタイプを指定します。
      * @param type パケットのタイプ
      */
     public enum PacketType {
          IUISERVERRESPONSE,
          IUIServerFastConnect,
          IUIUPLoadRequest,
          IUIDeleteRequest,
          IUIListGetRequest,
          IUIGetRequest,
     }
}
