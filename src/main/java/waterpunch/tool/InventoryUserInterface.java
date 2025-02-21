package waterpunch.tool;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import waterpunch.tool.data.Info;
import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.IuiCustomizer;

public final class InventoryUserInterface extends Info {

     private IUISize size = IUISize.x1;
     private IUIType type = IUIType.PRIVATE;

     private IuiCustomizer customizer = new IuiCustomizer();

     // private Inventory inv = Bukkit.createInventory(null, getSize().getCount(), super.getName());

     private ArrayList<IUIItem> items = new ArrayList<>();

     /**
      * デフォルトコンストラクタ
      * @see InventoryUserInterface#InventoryUserInterface(IUISize)
      * @see InventoryUserInterface#InventoryUserInterface(String)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */

     public InventoryUserInterface() {
          super();
     }

     /**
      * サイズを指定するコンストラクタ
      * @param size インベントリのサイズ
      * @see InventoryUserInterface#InventoryUserInterface()
      * @see InventoryUserInterface#InventoryUserInterface(String)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */
     public InventoryUserInterface(@Nonnull IUISize size) {
          super();
          setSize(size);
     }

     /**
      * 名前を指定するコンストラクタ
      * @param name インベントリの名前
      * @see InventoryUserInterface#InventoryUserInterface()
      * @see InventoryUserInterface#InventoryUserInterface(IUISize)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */
     public InventoryUserInterface(@Nonnull String name) {
          super(name);
     }

     /**
      * 名前とサイズを指定するコンストラクタ
      * @param name インベントリの名前
      * @param size インベントリのサイズ
      * @see InventoryUserInterface#InventoryUserInterface()
      * @see InventoryUserInterface#InventoryUserInterface(IUISize)
      * @see InventoryUserInterface#InventoryUserInterface(String)
      */
     public InventoryUserInterface(String name, @Nonnull IUISize size) {
          super(name);
          setSize(size);
     }

     /**
      * カスタマイザーを設定する
      * @param customizer カスタマイザー
      * @see InventoryUserInterface#getCustomizer()
      */
     public void setCustomizer(IuiCustomizer customizer) {
          this.customizer = customizer;
     }

     /**
      * カスタマイザーを取得する
      * @return カスタマイザー
      * @see InventoryUserInterface#setCustomizer(IuiCustomizer)
      */
     public IuiCustomizer getCustomizer() {
          return customizer;
     }

     /**
      * 特定の位置にアイテムを設定する
      * @param i 位置
      * @param item アイテム
      * @see InventoryUserInterface#getItem(int)
      */
     public void setItem(int i, IUIItem item) {
          if (i < 0 || i > getSize().getCount() - 1) return;

          items.set(i, item);
     }

     public ArrayList<IUIItem> getItems() {
          return items;
     }

     public IUIItem getItem(int i) {
          try {
               IUIItem item = getItems().get(i);
               return item;
          } catch (Exception e) {
               return null;
          }
     }

     /**
      * サイズを設定する
      * インベントリのサイズを変更すると、itemsリストのサイズも変更されます。
      * その際、サイズが小さくなる場合はitemsリストから削除され、大きくなる場合はnullで埋められます。
      * @see InventoryUserInterface#getSize()
      * @param size インベントリのサイズ
      */
     public void setSize(IUISize size) {
          this.size = size;

          if (items.size() > size.getCount()) {
               items.subList(size.getCount(), items.size()).clear();
          } else {
               while (items.size() < size.getCount()) {
                    items.add(null);
               }
          }
     }

     public IUISize getSize() {
          return size;
     }

     public void setType(IUIType type) {
          this.type = type;
     }

     public IUIType getType() {
          return type;
     }

     public void setItems(ArrayList<IUIItem> items) {
          this.items = items;
     }
}
