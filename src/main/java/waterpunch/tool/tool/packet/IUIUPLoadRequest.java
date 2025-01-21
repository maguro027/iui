package waterpunch.tool.tool.packet;

import waterpunch.tool.InventoryUserInterface;

public class IUIUPLoadRequest extends IUIPacket {

     private final InventoryUserInterface iui;

     public IUIUPLoadRequest(InventoryUserInterface iui) {
          super(PaketType.IUIUPLoadRequest);
          this.iui = iui;
     }
}
