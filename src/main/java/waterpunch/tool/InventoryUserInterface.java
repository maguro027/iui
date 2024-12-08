package waterpunch.tool;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import waterpunch.tool.data.IUISize;
import waterpunch.tool.data.IUIType;
import waterpunch.tool.tool.IuiCustomizer;

public final class InventoryUserInterface extends IuiCustomizer {

     private String name = "DEFAULT";
     private IUISize size = IUISize.x1;
     private IUIType type = IUIType.PRIVATE;

     private UUID owner;

     private ArrayList<ItemStack> items = new ArrayList<>();

     public InventoryUserInterface() {}

     public InventoryUserInterface(@Nonnull IUISize size) {
          if (!Objects.isNull(size)) setSize(size);
     }

     public InventoryUserInterface(String name, IUISize size) {
          if (!Objects.isNull(name)) setName(name);
          if (!Objects.isNull(size)) setSize(size);
     }

     public void setOwner(UUID owner) {
          this.owner = owner;
     }

     public Player getOwner() {
          return Bukkit.getPlayer(getOwnerUUID());
     }

     public UUID getOwnerUUID() {
          return owner;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return name;
     }

     public void setItem(int i, ItemStack item) {
          if (i < 0 || i > getSize().getCount() - 1) return;

          items.set(i, item);
     }

     public ArrayList<ItemStack> getItems() {
          return items;
     }

     public ItemStack getItem(int i) {
          //インベントリのサイズを確認し、サイズ以上ならエラーが発生します。
          //-1はインベントリが0から始まるための調整です。
          //TODO システムアイテムの場合はnullを返すようにします。
          if (i < 0 || i > getSize().getCount() - 1) return null;
          if (getItems().size() < i) return null;
          return getItems().get(i);
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
          Bukkit.createInventory(getOwner(), size.getCount(), getName());
          printBorder(this);
          return this;
     }
}
