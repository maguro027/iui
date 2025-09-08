package waterpunch.tool;

import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.tool.iuicustomize.Group;
import waterpunch.tool.tool.iuicustomize.GroupOption.GroupType;

public class TestSpeace {

    public static void main(String[] args) {
        // ClientPacket packet = new ServerFirstConnect();
        // String result;

        // result = packet.sendPacket();

        // System.out.println(result);

        // IUI Test

        Group group = new Group();
        group.addGroup("VIEW", 5, GroupType.VIEW);
        group.addGroup("BUTTON", 1, GroupType.BUTTON);
        group.addGroup("INVENTORY", 10, GroupType.INVENTORY);

        InventoryUserInterface iui = new InventoryUserInterface.Builder()
                .title("Test IUI")
                .size(IUISize.x3)
                .type(IUIType.PUBLIC)
                .group(group)
                .build();
    }
}
