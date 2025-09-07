package waterpunch.tool.item;

import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.Material;

import waterpunch.tool.data.enums.ItemType;
import waterpunch.tool.tool.messeage.ColoredText;

/**
 * IUIItemクラスは、インベントリユーザーインターフェース内で使用されるアイテムを表します。
 * このクラスはItemCreatorクラスを継承し、アイテムのタイプを保持します。
 *
 * @see ItemCreator
 * @author maguro027
 */
public class IUIItem extends ItemCreator {

    private final ItemType type = ItemType.VIEW;

    /**
     * コンストラクタ
     *
     * @param type アイテムのタイプ
     * @param material アイテムの素材
     * @param name アイテムの名前
     */
    public IUIItem(ItemType type, Material material, String name) {
        super(material, name);
    }

    /**
     * コンストラクタ
     *
     * @param type アイテムのタイプ
     * @param material アイテムの素材
     * @param name アイテムの名前
     * @param descriptions アイテムの説明
     */
    public IUIItem(ItemType type, @Nonnull Material material, String name, String descriptions) {
        super(material, name, descriptions);
    }

    /**
     * コンストラクタ
     *
     * @param type アイテムのタイプ
     * @param material アイテムの素材
     * @param name アイテムの名前
     * @param descriptions アイテムの説明
     */
    public IUIItem(ItemType type, @Nonnull Material material, String name,
            List<String> descriptions) {
        super(material, name, descriptions);
    }

    /**
     * アイテムのタイプを取得します。
     *
     * @return アイテムのタイプ
     */
    public ItemType getType() {
        return type;
    }

    /**
     * エラーアイテムを取得します。
     *
     * @return エラーアイテム
     * @see ItemType#SYSTEM_ITEM
     * @see Material#RED_STAINED_GLASS_PANE
     */
    public static IUIItem getERROR() {
        return new IUIItem(ItemType.SYSTEM_ITEM, Material.RED_STAINED_GLASS_PANE,
                ColoredText.setRED("ERROR"));
    }

    /**
     * 空白アイテムを取得します。
     *
     * @return インベントリボーダー用のアイテム
     * @see ItemType#VIEW
     * @see Material#BLACK_STAINED_GLASS_PANE
     */
    public static IUIItem getBLANK() {
        return new IUIItem(ItemType.VIEW, Material.BLACK_STAINED_GLASS_PANE, " ");
    }
}
