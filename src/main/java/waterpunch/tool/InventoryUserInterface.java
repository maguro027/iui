package waterpunch.tool;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import waterpunch.tool.tool.IuiCustomizer;

public final class InventoryUserInterface extends IuiCustomizer {

     private String name = "DEFAULT";
     private IUIType type = IUIType.PRIVATE;
     private IUISize size = IUISize.x1;
     private UUID owner;
     private ArrayList<ItemStack> items = new ArrayList<>();

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
          //TODO 最大サイズを超える場合はエラーを発生するようにします。

          items.set(i, item);
     }

     public ItemStack getItem(int i) {
          //TODO システムアイテムの場合はnullを返すようにします。
          ItemStack item = items.get(i);
          return item;
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

     public void print(Player player) {
          Inventory ResponseInventory = Bukkit.createInventory(getOwner(), size.getCount(), getName());
          player.openInventory(ResponseInventory);
     }
}
