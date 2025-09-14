package waterpunch.tool.tool.iuicustomize;

public class IUICSS {

    int groupSlot = 1;
    int inventorySlot = 1;

    public IUICSS(int groupSlot, int inventorySlot) {
        this.groupSlot = groupSlot;
        this.inventorySlot = inventorySlot;
    }

    public int getGroupSlot() {
        return groupSlot;
    }

    public int getInventorySlot() {
        return inventorySlot;
    }

}
