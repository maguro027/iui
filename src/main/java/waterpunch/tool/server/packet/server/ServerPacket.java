package waterpunch.tool.server.packet.server;

import waterpunch.tool.server.packet.IUIPacket;

public class ServerPacket extends IUIPacket {

     /**
      * @author maguro027
      * @version 0.1
      * このクラスは、サーバー用パケットの基底クラスです。
      */

     private ServerPacketType type = ServerPacketType.PING;

     public ServerPacket(ServerPacketType type) {
          super();
          setType(type);
     }

     public ServerPacketType getType() {
          return type;
     }

     public final void setType(ServerPacketType type) {
          this.type = type;
     }

     public enum ServerPacketType {
          PING,
          BadRequest,
     }
}
