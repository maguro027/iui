package waterpunch.tool;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import waterpunch.tool.data.Info;
import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.iuicustomize.Group;
import waterpunch.tool.tool.iuicustomize.IUICustom;

public final class InventoryUserInterface extends Group {

     private IUISize size;
     private IUIType type;
     private Info info;
     private IUICustom custom;
     private List<IUIItem> items;

     private InventoryUserInterface(Builder builder) {
          super();
          this.size = builder.size;
          this.type = builder.type;
          this.info = builder.info;
          this.custom = builder.custom;
          this.items = new ArrayList<>(builder.items);

          adjustItemsSize();
     }

     public static class Builder {
          private Info info = new Info();
          private IUISize size = IUISize.x1;
          private IUIType type = IUIType.PRIVATE;
          private IUICustom custom = new IUICustom(null);
          private List<IUIItem> items = new ArrayList<>();

          public Builder title(@Nonnull String title) {
               this.info.setName(title);
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

          public Builder items(List<IUIItem> items) {
               this.items = new ArrayList<>(items);
               return this;
          }

          public InventoryUserInterface build() {
               return new InventoryUserInterface(this);
          }
     }

     public Info getInfo() {
          return info;
     }

     public IUICustom getIUICustom() {
          return custom;
     }

     /**
      * すべてのアイテムをクリアし、サイズを調整します。
      */
     public void clear() {
          items.clear();
          adjustItemsSize();
     }

     /**
      * インベントリのサイズを設定し、アイテムリストを調整します。
      * 
      * @param size 新しいサイズ
      */
     public void setSize(IUISize size) {
          if (this.size == size) {
               return;
          }
          this.size = size;
          adjustItemsSize();
     }

     public IUISize getSize() {
          return size;
     }

     public IUIType getType() {
          return type;
     }

     public void setType(IUIType type) {
          this.type = type;
     }

     /**
      * itemsリストのサイズを現在のサイズに合わせて調整します。
      */
     private void adjustItemsSize() {
          int targetSize = size.getCount();
          // サイズが小さくなった場合、余分なアイテムを削除
          if (items.size() > targetSize) {
               items = new ArrayList<>(items.subList(0, targetSize));
          }
          // サイズが大きくなった場合、nullで埋める
          while (items.size() < targetSize) {
               items.add(null);
          }
     }
}