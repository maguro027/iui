package waterpunch.tool;

import org.bukkit.Material;

import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.data.enums.ItemType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.iuicustomize.GroupOption.GroupType;

public class TestSpeace {

    public static void main(String[] args) {

        InventoryUserInterface iui = new InventoryUserInterface.Builder()
                .title("Test IUI")
                .size(IUISize.x3)
                .type(IUIType.PUBLIC)
                .build();

        iui.addGroup("VIEW", 1, GroupType.VIEW);
        iui.addGroup("BUTTON", 3, GroupType.BUTTON);
        iui.addGroup("LIST", 10, GroupType.LIST);
        iui.addGroup("INVENTORY", 20, GroupType.INVENTORY);

        iui.setItem("VIEW", 1, new IUIItem(ItemType.VIEW, Material.DIAMOND_SWORD, "This is Test Item_1"));
        System.out.println(iui.getItem("VIEW", 1).getName());
        System.out.println("Test Complete");

    }

}
