package waterpunch.tool.tool.messeage.errorreport;

public class BADPacketError extends ErrorMessenger {

     private final String senderIP;
     private final int senderPort;
     private final String packetData;

     public BADPacketError(String senderIP, int senderPort, String packetData) {
          super(ErrorType.BADPacket);
          this.senderIP = senderIP;
          this.senderPort = senderPort;
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

     @Override
     public String encodeLog() {
          return super.encodeLog() + "\n" + "SenderIP : " + getSenderIP() + "\n" + "SenderPORT : " + getSenderPort() + "\n" + getPacketData();
     }
}
