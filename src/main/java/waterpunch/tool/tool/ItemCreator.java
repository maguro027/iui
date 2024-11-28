package waterpunch.tool.tool;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

     /**
      * @see アイテムを生成します。
      * @see 何らかのエラーが発生した場合、ERRORというアイテムを返還します。
      * @param material アイテムの見た目を設定します。
      * @param name アイテム名を生成します。文字コードにも対応しています。
      * @param descriptions 説明文を追加できます。もし説明が要らないのであれば null を入れてください。
      */
     static ItemStack getItem(@Nonnull Material material, String name, List<String> descriptions) {
          try {
               ItemStack response = new ItemStack(material);
               ItemMeta responseMeta = response.getItemMeta();
               responseMeta.setDisplayName(name);
               if (Objects.isNull(descriptions)) responseMeta.setLore(descriptions);
               response.setItemMeta(responseMeta);
               return response;
          } catch (Exception e) {
               return getERROR();
          }
     }

     /**
      * @see 何らかのエラーが発生したときに使用してください
      */

     public static ItemStack getERROR() {
          return getItem(Material.RED_STAINED_GLASS_PANE, "\u001b[00;31" + "ERROR" + "\u001b[00;00", null);
     }
}
