package waterpunch.tool.tool.iuicustomize;

import waterpunch.tool.item.IUIItem;

public class ItemHolder {
    private IUIItem item;
    // 1からスタート
    // -1は未設定
    private int slot = -1;

    public ItemHolder(IUIItem item, int slot) {
        setItem(item);
        setSlot(slot);
    }

    public IUIItem getItem() {
        return item;
    }

    private void setItem(IUIItem item) {
        this.item = item;
    }

    public int getSlot() {
        return slot;
    }

    private void setSlot(int slot) {
        this.slot = slot;
    }
}
