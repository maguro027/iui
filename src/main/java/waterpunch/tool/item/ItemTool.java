package waterpunch.tool.item;

import java.util.ArrayList;

/**
 * @author maguro027
 * @version 0.1
 */
public class ItemTool {

	/**
	 * アイテムリストにアイテムが存在するか確認します。IUIItemのUUIDを使用して比較します。
	 * 
	 * @param items アイテムリスト
	 * @param target 対象のアイテム
	 * @return アイテムが存在しない場合はtrue、存在する場合はfalse
	 */
	public static boolean checkItemList(ArrayList<IUIItem> items, IUIItem target) {
		// アイテムリストが空の場合はtrueを返します。
		if (items.isEmpty())
			return true;
		// アイテムリストのアイテムを1つずつ確認します。
		for (IUIItem item : items) {
			if (item.getName().equals(target.getName())) {
				return false;
			}
		}
		return true;
	}
}
