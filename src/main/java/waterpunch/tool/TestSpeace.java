package waterpunch.tool;

import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.ServerFirstConnect;

public class TestSpeace {

    public static void main(String[] args) {
        ClientPacket packet = new ServerFirstConnect();
        String result;

        result = packet.sendPacket();

        System.out.println(result);
    }
}
