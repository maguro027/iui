package waterpunch.tool;

import com.google.gson.Gson;
import org.bukkit.Material;
import waterpunch.tool.data.enums.ItemType;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.server.packet.client.ServerFirstConnect;

public class TestSpeace {

     public static void main(String[] args) {
          //同じアイテム追加したときのテスト
          //FirstConnectPacketのテスト

          Core.setPluginName("TESTNAME");
          // for (int i = 0; i < 1; i++) {
          //      ServerFirstConnect packet1 = new ServerFirstConnect();
          //      packet1.addItem(new IUIItem(ItemType.VIEW, Material.HOPPER, "TESTITEM"));
          //      packet1.addItem(new IUIItem(ItemType.VIEW, Material.HOPPER, "TESTITEM"));
          //      packet1.addItem(new IUIItem(ItemType.ERROR, Material.DIAMOND_SWORD, "TESTITEM_2"));
          //      System.out.println(packet1.sendPacket());
          // }
          ServerFirstConnect packet1 = new ServerFirstConnect();
          for (int i = 0; i < 24; i++) {
               packet1.addItem(new IUIItem(ItemType.VIEW, Material.HOPPER, String.valueOf(i), String.valueOf(i)));
          }
          System.out.println(new Gson().toJson(packet1));

          System.out.println(packet1.sendPacket());
     }
}
