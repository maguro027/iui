package waterpunch.tool.server;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.server.packet.IUIPacket;

/**
 * @author maguro027
 * @version 0.1
 */
public class IUIServer {

     static final HashMap<String, UUID> connectionServers = new HashMap<>();
     static final HashMap<String, ArrayList<InventoryUserInterface>> iuis = new HashMap<>();
     static final HashMap<String, ArrayList<IUIItem>> items = new HashMap<>();

     /**
     * デバッグ用のコードです
     * パケットを解析します。
     * @param packetData パケットのデータ
     * @return パケットのデータを解析した結果です、失敗した場合はnullを返します。
     */

     public IUIPacket Packetanalysis(byte[] packetData) {
          try {
               Gson gson = new Gson();
               return gson.fromJson(new String(packetData), IUIPacket.class);
          } catch (JsonSyntaxException e) {
               return null;
          }
     }
}
