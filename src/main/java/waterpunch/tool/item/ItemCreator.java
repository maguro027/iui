package waterpunch.tool.item;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import waterpunch.tool.data.Info;
import waterpunch.tool.tool.messeage.ColoredText;

/**
 *  @author maguro027
 */

public class ItemCreator extends Info {

     private final Material material;
     private List<String> descriptions;

     //システムアイテムの識別タグです。
     public static String SYSTEM_ITEM = ColoredText.setRED("SYSTEM_ITEM");

     /**
      * @see アイテムを生成します。
      * @see 何らかのエラーが発生した場合、ERRORというアイテムを返還します。
      * @param material アイテムの見た目を設定します。
      * @param name アイテム名を生成します。文字コードにも対応しています。
      * @param descriptions 説明文を追加できます。
      */
     public ItemCreator(Material material, String name) {
          super(name);
          this.material = material;
     }

     /**
      * @see アイテムを生成します。
      * @see 何らかのエラーが発生した場合、ERRORというアイテムを返還します。
      * @param material アイテムの見た目を設定します。
      * @param name アイテム名を生成します。文字コードにも対応しています。
      * @param descriptions 説明文を追加できます。
      */
     public ItemCreator(@Nonnull Material material, String name, String descriptions) {
          super(name);
          this.material = material;
          this.descriptions = Arrays.asList(descriptions);
     }

     /**
      * @see アイテムを生成します。
      * @see 何らかのエラーが発生した場合、ERRORというアイテムを返還します。
      * @param material アイテムの見た目を設定します。
      * @param name アイテム名を生成します。文字コードにも対応しています。
      * @param descriptions 複数行の説明文を追加できます。
      */
     public ItemCreator(@Nonnull Material material, String name, List<String> descriptions) {
          super(name);
          this.material = material;
          this.descriptions = descriptions;
     }

     public ItemStack getItem() {
          ItemStack item = new ItemStack(material);
          ItemMeta meta = item.getItemMeta();
          if (meta != null) {
               meta.setDisplayName(getName());
               if (descriptions != null) meta.setLore(descriptions);
          }
          item.setItemMeta(meta);
          return item;
     }
}
