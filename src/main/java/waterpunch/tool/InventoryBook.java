package waterpunch.tool;

import java.util.ArrayList;

import waterpunch.tool.data.enums.Info;

public class InventoryBook extends Info {

     private final ArrayList<InventoryUserInterface> list = new ArrayList<>();

     public InventoryBook(String name) {}

     /**
      * @see リストの最後にiuiを追加します。
      */
     public void addPage(InventoryUserInterface iui) {
          list.add(iui);
     }

     /**
      * @see ここで指定された番号のlistを置き換えます。
      * @param i 置き換える番号を代入してください。
      */
     public void setPage(int i, InventoryUserInterface iui) {
          list.set(i, iui);
     }

     /**
      * @see 指定したページを取得できるクラスです。
      * @param i 取得するページを代入してください。
      */
     public InventoryUserInterface getPage(int i) {
          return list.get(i);
     }

     public int getSize() {
          return list.size();
     }
}
