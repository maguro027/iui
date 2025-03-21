package waterpunch.tool;

import java.util.ArrayList;

public class IUITool {

     /**
      * リストにIUIが存在するか確認します。IUIItemのUUIDを使用して比較します。
      * 
      * @param iuis IUIリスト
      * @param target 対象のIUI
      * @return IUIが存在しない場合はtrue、存在する場合はfalse
      */
     public static boolean checkIUIList(ArrayList<InventoryUserInterface> iuis,
               InventoryUserInterface target) {
          for (InventoryUserInterface iui : iuis) {
               if (iui.getID() == target.getID()) {
                    return false;
               }
          }
          return true;
     }
}
