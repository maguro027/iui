package waterpunch.tool.tool.iuicustomize;

import java.util.ArrayList;
import java.util.HashMap;

public class Group {
    private HashMap<String, ArrayList<Integer>> group;

    private Group() {
        group = new HashMap<>();
    }

    public static class Builder {
        private HashMap<String, ArrayList<Integer>> group = new HashMap<>();

        public Builder() {
        }

        public Builder addGroup(String groupName) {
            group.put(groupName, new ArrayList<>());
            return this;
        }

        public Builder addValue(String groupName, Integer value) {
            // Remove value from all groups to ensure no duplicates

            removeValue(value);

            // Add value to the specified group
            group.computeIfAbsent(groupName, k -> new ArrayList<>()).add(value);
            return this;
        }

        public Builder removeGroup(String groupName) {
            group.remove(groupName);
            return this;
        }

        public void removeValue(Integer value) {
            for (ArrayList<Integer> values : group.values()) {
                values.remove(value);
            }
        }

        public Group build() {
            Group g = new Group();
            g.group = this.group;
            return g;
        }
    }

    public ArrayList<String> getGroupNames() {
        return new ArrayList<>(group.keySet());
    }

    public ArrayList<Integer> getValue(String groupName) {
        return group.get(groupName);
    }

    public HashMap<String, ArrayList<Integer>> getGroup() {
        return group;
    }

}
