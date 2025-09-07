package waterpunch.tool.server.packet.client;

import waterpunch.tool.item.IUIItem;

public class IUIItemUPLoadRequest extends ClientPacket {

    private IUIItem item;

    public IUIItemUPLoadRequest(IUIItem iuiItem) {
        super(ClientPacketType.IUIItemUPLoadRequest);
        setItem(iuiItem);
    }

    private void setItem(IUIItem item) {
        this.item = item;
    }

    public IUIItem getItem() {
        return item;
    }
}
