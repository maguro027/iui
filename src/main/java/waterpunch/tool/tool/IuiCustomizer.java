package waterpunch.tool.tool;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class IuiCustomizer extends ItemCreator {

     public static Inventory setBorder(Inventory inv) {
          ItemStack cash = null;

          switch (inv.getSize()) {
               case 1:
                    break;
               default:
                    throw new AssertionError();
          }
          for (int i = 0; i < 54; ++i) {
               if (i > 8 && i < 45) continue;
               cash = getItem(Material.BLACK_STAINED_GLASS_PANE, " ", null);
               inv.setItem(i, new ItemStack(cash));
          }
          return inv;
     }
}
