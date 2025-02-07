package waterpunch.tool.tool.messeage;

public class ErrorMessenger extends Messenger {

     ErrorMessenger(ErrorType type) {
          encodeLog(type.getMessage());
     }

     public enum ErrorType {
          BadPacketType(setRED("不正なパケットタイプです。"));

          private final String message;

          ErrorType(String message) {
               this.message = message;
          }

          public String getMessage() {
               return message;
          }
     }
}
