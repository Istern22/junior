package ru.job4j.exam;

import java.util.*;

public class DepartmentSort {

    public List<String> fillGaps(List<String> structure) {
        Set<String> departments = new TreeSet<>();
        for (String dep : structure) {
            String[] parts = dep.split("\\\\");
            String path = "";
            for (int i = 0; i < parts.length; i++) {
                path = (i == 0) ? parts[i] : path + "\\" + parts[i];
                departments.add(path);
            }
        }
        return new ArrayList<>(departments);
    }

    public ArrayList<String> sortAsc(List<String> structure) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> parents = getParents(structure);
        treeSort("", parents, result, true);
        return result;
    }

    public ArrayList<String> sortDesc(List<String> structure) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> parents = getParents(structure);
        treeSort("", parents, result, false);
        return result;
    }

    public HashMap<String, String> getParents(List<String> structure) {
        HashMap<String, String> result = new HashMap<>();
        for (String department : fillGaps(structure)) {
            int lastIndex = department.lastIndexOf("\\");
            if (lastIndex > 0) {
                String parent = department.substring(0, lastIndex);
                result.put(department, parent);
            } else {
                result.put(department, "");
            }
        }
        return result;
    }

    public void treeSort(String parent, HashMap<String, String> parents, List<String> result, boolean ascending) {
        ArrayList<String> children = new ArrayList<>();
        for (Map.Entry<String, String> entry : parents.entrySet()) {
            if (entry.getValue().equals(parent)) {
                children.add(entry.getKey());
            }
        }

        if (children.size() == 0) {
            return;
        }

        children.sort(ascending ? null : Collections.reverseOrder());
        for (String child : children) {
            result.add(child);
            treeSort(child, parents, result, ascending);
        }
    }
}
