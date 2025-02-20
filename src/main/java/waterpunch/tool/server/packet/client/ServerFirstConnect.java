package waterpunch.tool.server.packet.client;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、サーバーに最初に接続するためのパケットです。
 * ポートやIUIのバージョン情報を送信します。
 */
public final class ServerFirstConnect extends ClientPacket {

     /**
      * @see サーバーとの初回通信用のパケットです。
      */
     public ServerFirstConnect() {
          super(ClientPacketType.IUIServerFastConnect);
     }
}
