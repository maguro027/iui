package waterpunch.tool;

public class Core {

     public static String IUI_HOST = "localhost";
     public static int IUI_PORT = 12345;

     public static String iuiversion = "0.1A"; //IUIのバージョンを代入してください。
     public static String pluginName = "DEFAULT"; //呼び出し元のプラグイン名を代入してください。
     public static String version = "0"; //呼び出し元のプラグインのバージョンを代入してください。

     public static void setHost(String host) {
          IUI_HOST = host;
     }

     public static String getHost() {
          return IUI_HOST;
     }

     public static void setPort(int port) {
          IUI_PORT = port;
     }

     public static int getPort() {
          return IUI_PORT;
     }

     public static void setIUIVersion(String ver) {
          iuiversion = ver;
     }

     public static String getIUIVersion() {
          return iuiversion;
     }

     public static void setPluginName(String name) {
          pluginName = name;
     }

     public static String getPluginName() {
          return pluginName;
     }

     public static void setVersion(String ver) {
          version = ver;
     }

     public static String getVersion() {
          return version;
     }
}
