package waterpunch.tool;

import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.ServerFirstConnect;

public class TestSpeace {

     public static void main(String[] args) {
          Core.setPluginName("TESTNAME");
          for (int i = 0; i < 10; i++) {
               ClientPacket packet1 = new ServerFirstConnect();
               System.out.println(packet1.sendPacket());
          }
          ClientPacket packet = new ServerFirstConnect();
          String result;

          result = packet.sendPacket();

          System.out.println(result);
     }
}
