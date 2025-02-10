package waterpunch.tool.server.packet.client;

import waterpunch.tool.item.IUIItem;

public class IUIItemUPLoadRequest extends ClientPacket {

     private final IUIItem item;

     public IUIItemUPLoadRequest(IUIItem iuiItem) {
          super(ClientPacketType.IUIItemUPLoadRequest);
          this.item = iuiItem;
     }
}
