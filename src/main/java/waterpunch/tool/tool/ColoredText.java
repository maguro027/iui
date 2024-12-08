package waterpunch.tool.tool;

/**
 *  @author maguro027
 */
public abstract class ColoredText {

     /**
      * @see 入力された文字を赤色にして変換します。
      * @return 赤色に着色された文字
      */
     public static String setRED(String str) {
          return "\u001b[00;31" + str + setWhite();
     }

     /**
      * @see 入力された文字を黄色にして変換します。
      * @return 黄色に着色された文字
      */
     public static String setYELLOW(String str) {
          return "\u001b[00;33" + str + setWhite();
     }

     /**
      * @see 入力された文字を青色にして変換します。
      * @return 青色に着色された文字
      */
     public static String setBlue(String str) {
          return "\u001b[00;36" + str + setWhite();
     }

     /**
      * @see 呼び出すと白色の文字コードが変換され、その後の文字を白くします。
      * @return 白色の文字コード。
      */
     public static String setWhite() {
          return "\u001b[00;00";
     }
}
