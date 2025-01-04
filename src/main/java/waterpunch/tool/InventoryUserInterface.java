package waterpunch.tool;

import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.data.enums.Info;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.IuiCustomizer;

public final class InventoryUserInterface {

     private IUISize size = IUISize.x1;
     private IUIType type = IUIType.PRIVATE;

     private IuiCustomizer customizer = new IuiCustomizer();
     private Info info = new Info();

     private Inventory inv = Bukkit.createInventory(null, getSize().getCount(), getInfo().getName());

     private ArrayList<IUIItem> items = new ArrayList<>();

     /**
      * デフォルトコンストラクタ
      * @see InventoryUserInterface#InventoryUserInterface(IUISize)
      * @see InventoryUserInterface#InventoryUserInterface(String)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */
     public InventoryUserInterface() {
          IUIHolder.add(this);
     }

     /**
      * サイズを指定するコンストラクタ
      * @param size インベントリのサイズ
      * @see InventoryUserInterface#InventoryUserInterface()
      * @see InventoryUserInterface#InventoryUserInterface(String)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */
     public InventoryUserInterface(@Nonnull IUISize size) {
          setSize(size);
          IUIHolder.add(this);
     }

     /**
      * 名前を指定するコンストラクタ
      * @param name インベントリの名前
      * @see InventoryUserInterface#InventoryUserInterface()
      * @see InventoryUserInterface#InventoryUserInterface(IUISize)
      * @see InventoryUserInterface#InventoryUserInterface(String, IUISize)
      */
     public InventoryUserInterface(@Nonnull String name) {
          getInfo().setName(name);
          IUIHolder.add(this);
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
          if (!Objects.isNull(name)) getInfo().setName(name);
          setSize(size);
          IUIHolder.add(this);
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

          int newSize = size.getCount();
          if (items.size() > newSize) {
               items.subList(newSize, items.size()).clear();
          } else {
               while (items.size() < newSize) {
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

     public InventoryUserInterface printInventory() {
          inv = Bukkit.createInventory(info.getOwner(), size.getCount(), info.getName());
          customizer.printBorder(this);
          return this;
     }

     public void setItems(ArrayList<IUIItem> items) {
          this.items = items;
     }

     public Info getInfo() {
          return info;
     }

     public void setInfo(Info info) {
          this.info = info;
     }

     public int getInvHash() {
          return inv.hashCode();
     }
}
