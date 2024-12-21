package waterpunch.tool;

import java.util.ArrayList;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;

import waterpunch.tool.data.enums.IUISize;
import waterpunch.tool.data.enums.IUIType;
import waterpunch.tool.data.enums.Info;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.IuiCustomizer;

public final class InventoryUserInterface {

     private IUISize size = IUISize.x1;
     private IUIType type = IUIType.PRIVATE;

     private IuiCustomizer customizer;
     private Info info;

     private ArrayList<IUIItem> items = new ArrayList<>();

     public InventoryUserInterface() {}

     public InventoryUserInterface(@Nonnull IUISize size) {
          if (!Objects.isNull(size)) setSize(size);
     }

     public InventoryUserInterface(String name) {
          if (!Objects.isNull(name)) info.setName(name);
     }

     public InventoryUserInterface(String name, IUISize size) {
          if (!Objects.isNull(name)) info.setName(name);
          if (!Objects.isNull(size)) setSize(size);
     }

     public void setCustomizer(IuiCustomizer customizer) {
          this.customizer = customizer;
     }

     public IuiCustomizer getCustomizer() {
          return customizer;
     }

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
      * @see 結構重たい処理になっちゃうかも
      */
     public void setSize(IUISize size) {
          //TODO サイズに合わせてListを拡張します。内容物を消さないようにnullをセットして増やしたり減らしたり。
          this.size = size;
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
          Bukkit.createInventory(info.getOwner(), size.getCount(), info.getName());
          customizer.printBorder(this);
          return this;
     }

     public void setItems(ArrayList<IUIItem> items) {
          this.items = items;
     }
}
