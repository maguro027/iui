package waterpunch.tool.item;

import java.util.ArrayList;

public class ItemTool {

     /**
      * アイテムリストにアイテムが存在するか確認します。IUIItemのUUIDを使用して比較します。
      * @param items アイテムリスト
      * @param target 対象のアイテム
      * @return アイテムが存在しない場合はtrue、存在する場合はfalse
      */
     public static boolean checkItemList(ArrayList<IUIItem> items, IUIItem target) {
          for (IUIItem item : items) {
               if (item.getID() == target.getID()) {
                    return false;
               }
          }
          return true;
     }
}
