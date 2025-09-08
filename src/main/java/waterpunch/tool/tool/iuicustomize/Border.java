package waterpunch.tool.tool.iuicustomize;

import java.util.HashMap;

import waterpunch.tool.data.enums.IUISize;

public class Border {

    private BorderType type = BorderType.NONE;
    private IUISize size;
    private HashMap<String, Integer> group = new HashMap<>();

    public enum BorderType {
        NONE,
        NORMAL,
        ALLFILL,
        CUSTOM;
    }

    public Border(IUISize size, BorderType type) {
        setType(type);
        setSize(size);

    }

    private void setSize(IUISize size) {
        this.size = size;
    }

    public IUISize getSize() {
        return size;
    }

    private void setType(BorderType type) {
        this.type = type;
    }

    public BorderType getType() {
        return type;
    }

    public void allFill() {
        group.clear();
        for (int i = 0; i < getSize().getCount(); i++) {
            group.put("Layer-0", i);
        }
    }

    public void fill(String groupName, int i) {
        if (i >= 0 && i < getSize().getCount()) {
            group.put(groupName, i);
        }
    }

    public void fill(String groupName, int start, int end) {
        if (start < 0 || end < 0 || start >= getSize().getCount() || end >= getSize().getCount() || start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            group.put(groupName, i);
        }
    }

    public void removeFill(String groupName, int i) {
        group.remove(groupName, Integer.valueOf(i));
    }

    public HashMap<String, Integer> getFillSlots() {
        return group;
    }
}
