package waterpunch.tool.item;

import javax.annotation.Nonnull;

import org.bukkit.Material;

import waterpunch.tool.data.enums.ItemType;

public class IUIItem extends ItemCreator {

     private ItemType type;

     public IUIItem(ItemType type, @Nonnull Material material, String name) {
          super(material, name);
     }

     public IUIItem(ItemType type, @Nonnull Material material, String name, String descriptions) {
          super(material, name);
     }

     public ItemType getItemType() {
          return type;
     }

     /**
      * @see 何らかのエラーが発生したときに使用してください。
      */

     public static IUIItem getERROR() {
          return new IUIItem(ItemType.SYSTEM_ITEM, Material.RED_STAINED_GLASS_PANE, "\u001b[00;31" + "ERROR" + "\u001b[00;00");
     }

     public static IUIItem getBLANK() {
          return new IUIItem(ItemType.View, Material.BLACK_STAINED_GLASS_PANE, " ", SYSTEM_ITEM);
     }
}
