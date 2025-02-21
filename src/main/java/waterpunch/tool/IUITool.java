package waterpunch.tool;

import java.util.ArrayList;

public class IUITool {

     public static boolean checkIUIList(ArrayList<InventoryUserInterface> iuis, InventoryUserInterface target) {
          for (InventoryUserInterface iui : iuis) {
               if (iui.getID() == target.getID()) {
                    return false;
               }
          }
          return true;
     }
}
