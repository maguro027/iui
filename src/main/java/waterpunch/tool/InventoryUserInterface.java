package waterpunch.tool;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class InventoryUserInterface {

     private String Name = "DEFAULT";
     private IUIType Type = IUIType.PRIVATE;
     private IUISize Size = IUISize.x1;
     private UUID Owner;
     private ArrayList<ItemStack> Parts = new ArrayList<>();

     public InventoryUserInterface(String name, IUISize size) {
          upDateName(name);

          Size = size;
     }

     public void setOwner(UUID owner) {
          Owner = owner;
     }

     public UUID getOwnerUUID() {
          return Owner;
     }

     public Player getOwner() {
          return Bukkit.getPlayer(getOwnerUUID());
     }

     public void upDateName(String name) {
          Name = name;
     }

     public String getName() {
          return Name;
     }

     public void setType(IUIType type) {
          Type = type;
     }

     public IUIType getType() {
          return Type;
     }

     public void print() {
          Inventory ResponseInventory = Bukkit.createInventory(getOwner(), Size.getCount(), getName());
     }
}
