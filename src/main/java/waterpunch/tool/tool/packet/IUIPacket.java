package waterpunch.tool.tool.packet;

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
          IUIUPLoadRequest,
          IUIDeleteRequest,
          IUIListGetRequest,
          IUIGetRequest,
     }
}
