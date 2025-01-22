package waterpunch.tool.tool.packet;

import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIサーバーにIUIをアップロードするリクエストを送信するためのクラスです。
 */
public class IUIUPLoadRequest extends IUIPacket {

     private final InventoryUserInterface iui;

     public IUIUPLoadRequest(InventoryUserInterface iui) {
          super(PaketType.IUIUPLoadRequest);
          this.iui = iui;
     }
}
