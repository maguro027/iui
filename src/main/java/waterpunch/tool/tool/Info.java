package waterpunch.tool.tool;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Info {

     private String name = "DEFAULT";
     private UUID owner;

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return name;
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
}