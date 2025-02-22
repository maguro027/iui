package waterpunch.tool.tool.messeage.errorreport;

import java.net.Socket;

public class BADPacketError extends ErrorMessenger {

     private final BadPacketType BadPacketType;
     private final String senderIP;
     private final int senderPort;
     private final String packetData;

     public BADPacketError(BadPacketType BadPacketType, Socket socket, String packetData) {
          super(ErrorType.BADPacket);
          this.BadPacketType = BadPacketType;
          this.senderIP = socket.getInetAddress().getHostAddress();
          this.senderPort = socket.getPort();
          this.packetData = packetData;
     }

     public String getSenderIP() {
          return senderIP;
     }

     public int getSenderPort() {
          return senderPort;
     }

     public String getPacketData() {
          return packetData;
     }

     public BadPacketType getBadPacketType() {
          return BadPacketType;
     }

     public enum BadPacketType {
          BADPluginName(setRED("不正な名前が設定されています。")),
          CrushPacket(setRED("パケットが壊れています。")),
          BADRequest(setRED("その操作は許可されていません。"));

          private final String message;

          BadPacketType(String message) {
               this.message = message;
          }

          public String getMessage() {
               return message;
          }
     }

     @Override
     public String encodeLog() {
          return super.encodeLog() + "\n" + "SenderIP : " + getSenderIP() + "\n" + "SenderPORT : " + getSenderPort() + "\n" + getPacketData();
     }
}
