package waterpunch.tool.tool.packet;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIサーバーに飛ばすパケットの基底クラスです。
 */
public class IUIPacket {

     public static String pluginName;
     private PaketType type;

     public IUIPacket(PaketType type) {
          this.type = type;
     }

     public void setPaketType(PaketType type) {
          this.type = type;
     }

     public PaketType getType() {
          return type;
     }

     public enum PaketType {
          IUIServerFastConnect,
          IUIUPLoadRequest,
          IUIDeleteRequest,
          IUIListGetRequest,
          IUIGetRequest,
     }
}
