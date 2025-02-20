package waterpunch.tool.tool.messeage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @author maguro027
 *  @version 0.1
 *  このクラスはログの出力用クラスです。
 *　主に、日時やメッセージのエンコードを行います。
 */
public class Messenger extends ColoredText {

     private String messeage = "DEFAULT";

     public Messenger(String message) {
          setMesseage(message);
     }

     public final void setMesseage(String messeage) {
          this.messeage = messeage;
     }

     public String getMesseage() {
          return messeage;
     }

     public String getCurrentTime() {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          return sdf.format(new Date());
     }

     public String encodeLog() {
          return "[" + getCurrentTime() + "] " + messeage;
     }
}
