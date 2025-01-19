package waterpunch.tool.tool.packet;

import waterpunch.tool.InventoryUserInterface;

public class UploadPacket extends IUIPacket {

     private final InventoryUserInterface iui;
     private final PaketType type = PaketType.IUIUPLoadRequest;

     public UploadPacket(InventoryUserInterface iui) {
          this.iui = iui;
     }

     public PaketType getType() {
          return type;
     }
}
