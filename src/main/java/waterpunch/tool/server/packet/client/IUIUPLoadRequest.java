package waterpunch.tool.server.packet.client;

import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、IUIサーバーにIUIをアップロードするリクエストを送信するためのクラスです。
 */
public class IUIUPLoadRequest extends ClientPacket {

     private final InventoryUserInterface iui;

     public IUIUPLoadRequest(InventoryUserInterface iui) {
          super(ClientPacketType.IUIUPLoadRequest);
          this.iui = iui;
     }

     /**
      * @return IUIを返します。
      */
     public InventoryUserInterface getIUI() {
          return iui;
     }
}
