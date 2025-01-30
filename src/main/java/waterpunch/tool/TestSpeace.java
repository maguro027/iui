package waterpunch.tool;

import java.io.IOException;
import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.ServerFirstConnect;

public class TestSpeace {

     public static void main(String[] args) throws IOException {
          ClientPacket packet = new ServerFirstConnect();
          String result = packet.sendPacket();
          System.out.println(result);
     }
}
