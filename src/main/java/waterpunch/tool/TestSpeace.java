package waterpunch.tool;

import waterpunch.tool.tool.packet.IUIPacket;
import waterpunch.tool.tool.packet.ServerFirstConnect;

public class TestSpeace {

     public static void main(String[] args) {
          IUIPacket packet = new ServerFirstConnect();
          String result = packet.sendPacket();
          System.out.println(result);
     }
}
