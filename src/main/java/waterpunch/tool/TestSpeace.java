package waterpunch.tool;

import org.bukkit.Material;
import waterpunch.tool.data.enums.ItemType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.server.packet.client.ServerFirstConnect;

public class TestSpeace {

     public static void main(String[] args) {
          Core.setPluginName("TESTNAME");
          for (int i = 0; i < 1; i++) {
               ServerFirstConnect packet1 = new ServerFirstConnect();
               packet1.addItem(new IUIItem(ItemType.VIEW, Material.HOPPER, "TESTITEM"));
               System.out.println(packet1.sendPacket());
          }
          // ClientPacket packet = new ServerFirstConnect();
          // String result;

          // result = packet.sendPacket();

          // System.out.println(result);
     }
}
