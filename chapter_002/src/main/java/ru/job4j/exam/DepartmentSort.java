package ru.job4j.exam;

import java.util.*;

public class DepartmentSort {

    /**
     * Проходим по каждому элементу массива, разбиваем его на части
     * Вычисляем путь до подразделения(включительно) и до родителя(не включая сам элемент)
     * Если такой путь не содержится в массиве подразделений, то добавляем путь и его родителя
     * Таким образом будут добавлены недостающие элементы дерева
     * Нужно добавлять полный путь, чтобы потом по нему сортировать
     * Нужно добавлять полный путь до родителя, чтобы различать путь через одинаковые промежуточные элементы
     * @param structure исходный массив подразделений
     */
    public ArrayList<String> fillGaps(String[] structure) {
        ArrayList<String> departments = new ArrayList<>();
        for (String dep : structure) {
            String[] parts = dep.split("\\\\");
            String path = "";
            for (int i = 0; i < parts.length; i++) {
                path = (i == 0) ? parts[i] : path + "\\" + parts[i];
                departments.add(path);
            }
        }
        return departments;
    }

    public ArrayList<String> parents(String[] structure) {
        ArrayList<String> parents = new ArrayList<>();
        for (String dep : fillGaps(structure)) {
            String[] parts = dep.split("\\\\");
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    parents.add(parts[i]);
                }
            }
        }
        return parents;
    }

    public ArrayList<String> sortAsc(String[] structure) {
       Set<String> result = new TreeSet<>(fillGaps(structure));
       return new ArrayList(result);
    }

    public ArrayList<String> sortDesc(String[] structure) {
        TreeSet<String> departments = new TreeSet<>(fillGaps(structure));
        TreeSet<String> parents = new TreeSet<>(parents(structure));
        NavigableSet<String> parentsDesc = parents.descendingSet();
        TreeSet<String> children = new TreeSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (String parent: parentsDesc) {
            for (String dep : departments) {
                if (dep.contains(parent)) {
                    children.add(dep);
                }
            }
            result.add(parent);
            result.addAll(children);
        }
        return result;
    }
}
