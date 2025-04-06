package waterpunch.tool.tool;

import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;

/**
 * @author maguro027
 * @author maguro027
 */
public class IuiCustomizer {

    private boolean border;

    /**
     * @see ボーダーのONとOFFが切り替えれます、TrueでONです。
     * @see printBorder()を実行しないと切り替わりません。
     */
    public void setBorder(boolean yn) {
        border = yn;
    }

    public boolean getBorder() {
        return border;
    }

    /**
     * @see IUIの上下等にBorderを設置できます。
     * @see サイズなどは内部で判断しますので気にせず入れてください。
     * @see ボーダーの形は内部のコメントで詳細を書いていますので、確認してください。
     * @param inv IUIで生成したものを代入してください、中身が入っていてボーダーに被るアイテムは削除されます。
     */
    public InventoryUserInterface printBorder(InventoryUserInterface inv) {
        if (!getBorder()) {
            return inv;
        }
        // ボーダーアイテムを生成します、空白等を埋めてください。
        switch (inv.getSize()) {
            case x1:
                // 左右1マスずつにボーダーを設定します。

                inv.setItem(0, IUIItem.getBLANK());
                inv.setItem(8, IUIItem.getBLANK());

                break;
            case x2:
                // 下の段のみにボーダーを設定します。

                for (int i = 9; i < inv.getSize().getCount(); ++i) {
                    inv.setItem(i, IUIItem.getBLANK());
                }

                break;
            case x3:
            case x4:
            case x5:
            case x6:
                // 上下段にボーダーを設定します。

                for (int i = 0; i < inv.getSize().getCount(); ++i) {
                    if (i > 8 && i < inv.getSize().getCount() - 9) {
                        continue;
                    }
                    inv.setItem(i, IUIItem.getBLANK());
                }

                break;
            default:
                break;
        }
        return inv;
    }
}
