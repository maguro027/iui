package waterpunch.tool.tool.messeage.errorreport;

import waterpunch.tool.tool.messeage.Messenger;

/**
 *  @author maguro027
 */
public class ErrorMessenger extends Messenger {

     private final String incidentDay = getCurrentTime();

     public ErrorMessenger(ErrorType type) {
          super(getErrorTitle() + type.getMessage());
     }

     public static final String getErrorTitle() {
          return "[" + setRED("-ERROR-") + "]";
     }

     public String getIncidentDay() {
          return incidentDay;
     }

     public enum ErrorType {
          BADPacket(setRED("不正なパケットタイプです。")),
          BADRequest(setRED("その操作は許可されていません。"));

          private final String message;

          ErrorType(String message) {
               this.message = message;
          }

          public String getMessage() {
               return message;
          }
     }
}
