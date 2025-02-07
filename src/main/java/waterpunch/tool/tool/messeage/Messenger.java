package waterpunch.tool.tool.messeage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Messenger extends ColoredText {

     public static void main(String[] str) {

          //TODO テスト用のコードです

          String testMessage = "This is a test message.";
          String timestamp = getCurrentTime();
          encodeLog("[" + timestamp + "] " + testMessage);
     }

     public static void encodeLog(String str) {
          System.out.println(str);
     }

     public static String getCurrentTime() {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          return sdf.format(new Date());
     }
}
