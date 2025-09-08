package waterpunch.tool;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import waterpunch.tool.data.Info;
import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.IuiCustomizer;
import waterpunch.tool.tool.iuicustomize.IUICustom;

public final class InventoryUserInterface extends Info {

     private IUISize size = IUISize.x1;
     private IUIType type = IUIType.PRIVATE;

     private IUICustom custom = new IUICustom(null, null);

     private ArrayList<IUIItem> items = new ArrayList<>();

     private InventoryUserInterface(Builder builder) {
          super(builder.name);
          this.size = builder.size;
          this.type = builder.type;
          this.custom = builder.custom;
          this.items = builder.items;
     }

     public static class Builder {
          private String name = "";
          private IUISize size = IUISize.x1;
          private IUIType type = IUIType.PRIVATE;
          private IUICustom custom = new IUICustom(null, null);
          private ArrayList<IUIItem> items = new ArrayList<>();

          public Builder() {
          }

          public Builder name(@Nonnull String name) {
               this.name = name;
               return this;
          }

          public Builder size(@Nonnull IUISize size) {
               this.size = size;
               return this;
          }

          public Builder type(@Nonnull IUIType type) {
               this.type = type;
               return this;
          }

          public Builder custom(IUICustom custom) {
               this.custom = custom;
               return this;
          }

          public Builder items(ArrayList<IUIItem> items) {
               this.items = items;
               return this;
          }

          public InventoryUserInterface build() {
               return new InventoryUserInterface(this);
          }
     }

     /**
      * カスタマイザーを取得する
      * @return カスタマイザー
      * @see InventoryUserInterface#setCustomizer(IuiCustomizer)
      */
     public IUICustom getIUICustom() {
          return custom;
     }

     /**
      * アイテムを全て削除する
      */
     public void clear() {
          items.clear();
     }

     /**
      * アイテムを追加する
      * @param item 最後尾に追加されます。
      * @see InventoryUserInterface#setItem(int, IUIItem)
      */
     public void addItem(IUIItem item) {
          items.add(item);
     }

     /**
      * 特定の位置にアイテムを追加する
      * @param i 位置
      * @param i サイズ以上の数値を入れると最後尾に追加されます。
      * @param item アイテムがあった場合はその位置に挿入され、以降のアイテムが1つ後ろにずれます。
      * @see InventoryUserInterface#setItem(int, IUIItem)
      * @see InventoryUserInterface#getItem(int)
      */
     public void addItem(int i, IUIItem item) {
          if (i < 0 || i > getSize().getCount() - 1) {
               items.add(item);
               return;
          }
          items.add(i, item);
     }

     /**
      * 特定の位置にアイテムを設定する
      * @param i 位置
      * @param item アイテム
      * @see InventoryUserInterface#getItem(int)
      */
     public void setItem(int i, IUIItem item) {
          if (i < 0 || i > getSize().getCount() - 1)
               return;

          items.set(i, item);
     }

     /**
      * アイテムを全て設定する
      * @param items アイテムのリスト
      * @param items すべてを上書きします。
      * @see InventoryUserInterface#getItems()
      */
     public void setItem(ArrayList<IUIItem> items) {
          clear();
          this.items = items;
     }

     /**
      * アイテムを全て取得する
      * @return アイテムのリスト
      */
     public ArrayList<IUIItem> getItems() {
          return items;
     }

     /**
      * 特定の位置のアイテムを取得する
      * @param i 位置
      * @return アイテムが存在しない場合はnullを返します。
      */
     public IUIItem getItem(int i) {
          try {
               IUIItem item = getItems().get(i);
               return item;
          } catch (Exception e) {
               return null;
          }
     }

     /**
     * サイズを設定する インベントリのサイズを変更すると、itemsリストのサイズも変更されます。
     * その際、サイズが小さくなる場合はitemsリストから削除され、大きくなる場合はnullで埋められます。
     *
     * @see InventoryUserInterface#getSize()
     * @param size インベントリのサイズ
     */
     public void setSize(IUISize size) {
          this.size = size;

          if (items.size() >= size.getCount()) {
               items.subList(size.getCount(), items.size()).clear();
               return;
          }
          while (items.size() < size.getCount()) {
               items.add(null);
          }

     }

     public IUISize getSize() {
          return size;
     }

     public IUIType getType() {
          return type;
     }

}
