package waterpunch.tool.data.enums;

/**
 * @author maguro027
 * @see このenumはMinecraftのインベントリサイズを決めるために用います。
 */

public enum IUISize {
     AUTO(-1),
     x1(9),
     x2(18),
     x3(27),
     x4(36),
     x5(45),
     x6(54);

     private final int Count;

     private IUISize(int count) {
          Count = count;
     }

     public int getCount() {
          return Count;
     }
}
