package waterpunch.tool.server.packet.server.errors;

import waterpunch.tool.server.packet.server.ServerPacket;

public class BadRequest extends ServerPacket {

     public BadRequest() {
          super(ServerPacketType.BadRequest);
     }
}
