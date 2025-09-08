package waterpunch.tool.data.enums;

/**
 * @author maguro027
 * @see このenumはMinecraftのインベントリサイズを決めるために用います。
 */
public enum IUISize {
     AUTO(-1),
     x1(8),
     x2(17),
     x3(26),
     x4(35),
     x5(44),
     x6(53);

     private final int Count;

     private IUISize(int count) {
          Count = count;
     }

     public int getCount() {
          return Count;
     }
}
