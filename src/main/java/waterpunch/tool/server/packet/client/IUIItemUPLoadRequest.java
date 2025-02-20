package waterpunch.tool.server.packet.client;

import java.util.ArrayList;
import waterpunch.tool.item.IUIItem;

public final class IUIItemUPLoadRequest extends ClientPacket {

     private final ArrayList<IUIItem> items = new ArrayList<>();

     public IUIItemUPLoadRequest(IUIItem iuiItem) {
          super(ClientPacketType.IUIItemUPLoadRequest);
          addItem(iuiItem);
     }

     public IUIItemUPLoadRequest(ArrayList<IUIItem> iuiItems) {
          super(ClientPacketType.IUIItemUPLoadRequest);
          items.addAll(iuiItems);
     }

     public void addItem(IUIItem iuiItem) {
          items.add(iuiItem);
     }

     public ArrayList<IUIItem> getItems() {
          return items;
     }

     public IUIItem getItem(int index) {
          return items.get(index);
     }
}
