package waterpunch.tool.server.packet.client;

import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1 このクラスは、サーバーに最初に接続するためのパケットです。 ポートやIUIのバージョン情報を送信します。
 */
public final class ServerFirstConnect extends IUIItemUPLoadRequest {

     private final String version;

     /**
      * @see サーバーとの初回通信用のパケットです。
      * @see 名前の登録とついでにパブリックアイテムの登録をします。
      */
     public ServerFirstConnect() {
          super();
          version = Core.getIUIVersion();
          setPacketType(ClientPacketType.IUIServerFastConnect);
     }

     /**
      * @see IUIのバージョンを取得します。
      * @return IUIのバージョン
      */

     public String getVersion() {
          return version;
     }
}
