package waterpunch.tool.tool;

import org.bukkit.inventory.ItemStack;

import waterpunch.tool.InventoryUserInterface;

/**
 *  @author maguro027
 */
public class IuiCustomizer extends ItemCreator {

     /**
      * @see IUIの上下等にBorderを設置できます。
      * @see サイズなどは内部で判断しますので気にせず入れてください。
      * @see ボーダーの形は内部のコメントで詳細を書いていますので、確認してください。
      * @param inv IUIで生成したものを代入してください、中身が入っていてボーダーに被るアイテムは削除されます。
      */
     public static InventoryUserInterface setBorder(InventoryUserInterface inv) {
          //ボーダーアイテムを生成します、空白等を埋めてください。
          ItemStack cash = getBLANK();

          switch (inv.getSize()) {
               case x1:
                    //左右1マスずつにボーダーを設定します。
                    inv.setItem(0, new ItemStack(cash));
                    inv.setItem(8, new ItemStack(cash));
                    break;
               case x2:
                    //下の段のみにボーダーを設定します。

                    for (int i = 9; i < inv.getSize().getCount(); ++i) {
                         inv.setItem(i, new ItemStack(cash));
                    }
                    break;
               case x3:
               case x4:
               case x5:
               case x6:
                    //上下段にボーダーを設定します。

                    for (int i = 0; i < inv.getSize().getCount(); ++i) {
                         if (i > 8 && i < inv.getSize().getCount() - 9) continue;
                         inv.setItem(i, new ItemStack(cash));
                    }
                    break;
               default:
                    break;
          }
          return inv;
     }
}
