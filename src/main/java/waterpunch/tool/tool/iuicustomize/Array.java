package waterpunch.tool.tool.iuicustomize;

import java.util.HashMap;

public class Array {

    private HashMap<String, Integer> group = new HashMap<>();

    public Array() {
    }

    public void addGroup(String groupName) {
        group.put(groupName, 0);
    }

    public Integer getGroup(String groupName) {
        return group.get(groupName);
    }

    public void removeGroup(String groupName) {
        group.remove(groupName);
    }

    public void setValue(String groupName, Integer value) {
        group.replace(groupName, value);
    }

    public void setValue(String groupName, int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            group.replace(groupName, i);
        }
    }

    public void setGroup(String groupName, Integer value) {
        group.put(groupName, value);
    }

    public HashMap<String, Integer> getGroup() {
        return group;
    }

    public void clear() {
        group.clear();
    }
}
