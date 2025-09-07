package waterpunch.tool.server.packet.server.errors;

import waterpunch.tool.server.packet.server.ServerPacket;
import waterpunch.tool.tool.messeage.ColoredText;

public class BadRequest extends ServerPacket {

     private final BadPacketType BadPacketType;

     public BadRequest(BadPacketType BadPacketType) {
          super(ServerPacketType.BadRequest);
          this.BadPacketType = BadPacketType;
     }

     public BadPacketType getBadPacketType() {
          return BadPacketType;
     }

     public enum BadPacketType {
          BADPluginName(ColoredText.setRED("不正な名前が設定されています。")), CrushPacket(
                    ColoredText.setRED("パケットが壊れています。")), ExistingName(
                              ColoredText.setRED("その名前は既に存在します。")),

          BADRequest(ColoredText.setRED("その操作は許可されていません。"));

          private final String message;

          BadPacketType(String message) {
               this.message = message;
          }

          public String getMessage() {
               return message;
          }
     }
}
