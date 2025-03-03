package waterpunch.tool.tool.messeage.errorreport;

import java.net.Socket;

import waterpunch.tool.server.packet.server.errors.BadRequest;

public class BADPacketErrorReport extends ErrorMessenger {

     private final String days;
     private final String packetData;
     private final BadRequest errorPacket;
     private final String senderIP;
     private final int senderPort;

     public BADPacketErrorReport(BadRequest errorPacket, String packetData, Socket socket) {
          super(ErrorType.BADPacket);
          days = super.getIncidentDay();
          this.errorPacket = errorPacket;
          this.packetData = packetData;
          this.senderIP = socket.getInetAddress().getHostAddress();
          this.senderPort = socket.getPort();
     }

     @Override
     public String getIncidentDay() {
          return days;
     }

     public BadRequest getErrorPacket() {
          return errorPacket;
     }

     public String getPacketData() {
          return packetData;
     }

     public String getSenderIP() {
          return senderIP;
     }

     public int getSenderPort() {
          return senderPort;
     }

     public BadRequest getBadRequest() {
          return errorPacket;
     }

     @Override
     public String encodeLog() {
          return super.encodeLog() + getBadRequest().getBadPacketType().getMessage();
     }

     public String encodeDeta() {
          return "SenderIP : " + getSenderIP() + "\n" + "SenderPORT : " + getSenderPort() + "\n" + getPacketData();
     }
}
