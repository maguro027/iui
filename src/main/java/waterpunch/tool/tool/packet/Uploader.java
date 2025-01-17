package waterpunch.tool.tool.packet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import org.bukkit.plugin.java.JavaPlugin;
import waterpunch.tool.InventoryUserInterface;

/**
 * @author maguro027
 */
public class Uploader extends JavaPlugin {

     public static String IUI_HOST;
     public static int IUI_PORT;

     public void boot() {
          IUI_HOST = getConfig().getString("IUI_IP", "localhost");
          IUI_PORT = getConfig().getInt("IUI_PORT", 7500);
          saveConfig();
     }

     public static void sendIUI(InventoryUserInterface iui) throws IOException {
          // ソケットの作成
          try (Socket socket = new Socket(IUI_HOST, IUI_PORT); OutputStream out = socket.getOutputStream()) {
               String json = new Gson().toJson(iui);
               byte[] bytes = json.getBytes();
               // データの送信
               out.write(bytes);

               out.close();
               socket.close();
          }
     }
}
