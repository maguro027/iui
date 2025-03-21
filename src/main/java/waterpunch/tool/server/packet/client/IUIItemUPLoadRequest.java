package waterpunch.tool.server.packet.client;

import java.util.ArrayList;

import waterpunch.tool.item.IUIItem;

public class IUIItemUPLoadRequest extends ClientPacket {

    private final ArrayList<IUIItem> items = new ArrayList<>();

    public IUIItemUPLoadRequest() {
        super(ClientPacketType.IUIItemUPLoadRequest);
    }

    public IUIItemUPLoadRequest(IUIItem iuiItem) {
        super(ClientPacketType.IUIItemUPLoadRequest);
        addItem(iuiItem);
    }

    public IUIItemUPLoadRequest(ArrayList<IUIItem> iuiItems) {
        super(ClientPacketType.IUIItemUPLoadRequest);
        items.addAll(iuiItems);
    }

    public final void addItem(IUIItem iuiItem) {
        items.add(iuiItem);
    }

    public void addItems(ArrayList<IUIItem> iuiItems) {
        items.addAll(iuiItems);
    }

    public IUIItem getItem(int index) {
        return items.get(index);
    }

    public ArrayList<IUIItem> getItems() {
        return items;
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void clearItems() {
        items.clear();
    }

    public int size() {
        return items.size();
    }
}
