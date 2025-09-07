package waterpunch.tool.server.packet.client;

/**
 * @author maguro027
 * @version 0.1 このクラスは、サーバーに最初に接続するためのパケットです。 ポート情報を送信します。
 */
public final class ServerFirstConnect extends ClientPacket {

     /**
      * @see サーバーとの初回通信用のパケットです。
      * @see 名前の登録とついでにパブリックアイテムの登録をします。
      */
     public ServerFirstConnect() {
          super(ClientPacketType.IUIServerFastConnect);
     }

}
