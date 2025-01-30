package waterpunch.tool.server.packet.client;

import waterpunch.tool.Core;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、サーバーに最初に接続するためのパケットです。
 * ポートやIUIのバージョン情報を送信します。
 */
public final class ServerFirstConnect extends ClientPacket {

     private String version;

     /**
      * 内部の変数は送信用なので、内容取得等は不要です。
      * @see サーバーとの初回通信用のパケットです。
      */
     public ServerFirstConnect() {
          super(ClientPacketType.IUIServerFastConnect);
          setIUIVersion(Core.getIUIVersion());
     }

     /**
      * @param version IUIのバージョン情報
      */
     public void setIUIVersion(String version) {
          this.version = version;
     }

     /**
      * @return IUIのバージョン情報を返します。
      */
     public String getIUIVersion() {
          return version;
     }
}
