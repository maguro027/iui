package waterpunch.tool.tool.iuicustomize;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Nullable;

import waterpunch.tool.item.IUIItem;
import waterpunch.tool.tool.iuicustomize.GroupOption.GroupType;

public class Group {
    // キーに一意なグループ名（String）を使用し、値にGroupDataのラッパークラスを使用する
    private HashMap<String, GroupData> groups = new HashMap<>();

    public Group() {
    }

    /**
     * 新しいグループを追加します。既に存在する場合は何もしません。
     * * @param groupName グループ名
     * 
     * @param maxCount 最大アイテム数
     * @param type     グループタイプ
     */
    public void addGroup(String groupName, int maxCount, GroupType type) {
        groups.putIfAbsent(groupName, new GroupData(new GroupOption(groupName, maxCount, type), new ArrayList<>()));
    }

    /**
     * グループにアイテムを追加します。
     * * @param groupName グループ名
     * 
     * @param item 追加するアイテム
     */
    public void addItem(String groupName, IUIItem item) {
        GroupData data = groups.get(groupName);

        if (data == null) {
            return;
        }

        ArrayList<ItemHolder> items = data.getItems();
        GroupOption option = data.getOption();

        // 最大アイテム数が1の場合、既存のアイテムをクリアして追加
        if (option.getMaxCount() == 1) {
            items.clear();
            items.add(new ItemHolder(item, 1));
            return;
        }

        // 最大アイテム数を超えていないかチェック
        if (items.size() >= option.getMaxCount()) {
            return;
        }

        // アイテムを追加
        items.add(new ItemHolder(item, items.size() + 1));
    }

    /**
     * グループを削除します。
     * * @param groupName 削除するグループ名
     */
    public void removeGroup(String groupName) {
        groups.remove(groupName);
    }

    /**
     * グループから特定のアイテムを削除します。
     * * @param groupName グループ名
     * 
     * @param itemName 削除するアイテム名
     */
    public void removeItem(String groupName, String itemName) {
        GroupData data = groups.get(groupName);
        if (data != null) {
            data.getItems().removeIf(itemHolder -> itemHolder.getItem().getName().equals(itemName));
        }
    }

    /**
     * 全てのグループオプションを取得します。
     * * @return グループオプションのリスト
     */
    public ArrayList<GroupOption> getGroups() {
        ArrayList<GroupOption> options = new ArrayList<>();
        for (GroupData data : groups.values()) {
            options.add(data.getOption());
        }
        return options;
    }

    /**
     * グループ内のアイテムリストを取得します。
     * * @param groupName グループ名
     * 
     * @return アイテムのリスト。グループが見つからない場合はnull
     */
    @Nullable
    public ArrayList<ItemHolder> getValue(String groupName) {
        GroupData data = groups.get(groupName);
        return data != null ? data.getItems() : null;
    }

    /**
     * 全てのグループデータを取得します。
     * * @return 全てのグループデータを含むマップ
     */
    public HashMap<String, GroupData> getGroupsMap() {
        return groups;
    }
}

/**
 * グループのオプションとアイテムリストを保持する内部クラス。
 * 可読性を向上させるためのヘルパークラスです。
 */
class GroupData {
    private GroupOption option;
    private ArrayList<ItemHolder> items;

    public GroupData(GroupOption option, ArrayList<ItemHolder> items) {
        this.option = option;
        this.items = items;
    }

    public GroupOption getOption() {
        return option;
    }

    public ArrayList<ItemHolder> getItems() {
        return items;
    }
}