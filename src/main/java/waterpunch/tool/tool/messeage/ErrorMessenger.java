package waterpunch.tool.tool.messeage;

/**
 *  @author maguro027
 */
public class ErrorMessenger extends Messenger {

     private String incidentDay;

     public ErrorMessenger(ErrorType type) {
          super(type.getMessage());
          this.incidentDay = getCurrentTime();
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
