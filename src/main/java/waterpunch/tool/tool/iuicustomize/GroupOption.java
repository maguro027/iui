package waterpunch.tool.tool.iuicustomize;

public class GroupOption {
    private String groupName;
    private int maxCount = 1;
    private GroupType type = GroupType.VIEW;

    public static enum GroupType {
        VIEW,
        BUTTON,
        LIST,
        INVENTORY;
    }

    public GroupOption(String groupName, int maxCount, GroupType type) {
        setGroupName(groupName);
        setMaxCount(maxCount);
        setType(type);
    }

    public String getGroupName() {
        return groupName;
    }

    private void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMaxCount() {
        return maxCount;
    }

    private void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public GroupType getType() {
        return type;
    }

    private void setType(GroupType type) {
        this.type = type;
    }

}
