package waterpunch.tool.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import waterpunch.tool.IUIHolder;
import waterpunch.tool.InventoryUserInterface;

/**
 * IUIClickクラスは、インベントリユーザーインターフェース内でのクリックイベントを処理します。
 * @author maguro027
 */
public class IUIClick implements Listener {

     public static class IUIClickEvent extends Event {

          private final Player player;
          private final InventoryUserInterface iuinventory;
          private final int click;

          public IUIClickEvent(Player player, InventoryUserInterface iuinventory, int click) {
               this.player = player;
               this.iuinventory = iuinventory;
               this.click = click;
          }

          public Player getPlayer() {
               return player;
          }

          public InventoryUserInterface getInventory() {
               return iuinventory;
          }

          public int getClick() {
               return click;
          }

          @Override
          public HandlerList getHandlers() {
               // TODO Auto-generated method stub
               throw new UnsupportedOperationException("Unimplemented method 'getHandlers'");
          }

          @EventHandler
          public void onInventoryClickEvent(InventoryClickEvent event) {
               if (!event.getInventory().toString().matches(".*" + "Custom" + ".*") && event.getInventory().getType() != InventoryType.CHEST) return;
               IUIClickEvent iui = new IUIClickEvent((Player) event.getWhoClicked(), IUIHolder.get(event.getInventory()), event.getRawSlot());
               Bukkit.getServer().getPluginManager().callEvent(iui);
          }
     }
}
