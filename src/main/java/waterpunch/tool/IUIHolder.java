package waterpunch.tool;

import java.util.HashMap;
import org.bukkit.inventory.Inventory;

public class IUIHolder {

     public static HashMap<Integer, InventoryUserInterface> iuis = new HashMap<>();

     public static void add(InventoryUserInterface iui) {
          iuis.put(iui.getInvHash(), iui);
     }

     public static InventoryUserInterface get(Inventory inv) {
          for (InventoryUserInterface i : iuis.values()) {
               if (i.getInvHash() == inv.hashCode()) {
                    return i;
               }
          }
          return null;
     }

     public static void remove(Inventory inv) {
          iuis.remove(inv.hashCode());
     }
}
