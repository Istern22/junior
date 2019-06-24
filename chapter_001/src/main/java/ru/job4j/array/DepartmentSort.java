package ru.job4j.array;

import java.lang.String;
import java.util.ArrayList;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class DepartmentSort {
    /**
     * Проходим по каждому элементу массива, разбиваем его на части     *
     * Вычисляем путь до подразделения(включительно) и до родителя(не включая сам элемент)
     * Если такой путь не содержится в массиве подразделений, то добавляем путь и его родителя
     * Таким образом будут добавлены недостающие элементы дерева
     * Нужно добавлять полный путь, чтобы потом по нему сортировать
     * Нужно добавлять полный путь до родителя, чтобы различать путь через одинаковые промежуточные элементы
     * @param departments лист родительских департаментов
     * @param parents лист дочерних подразделений
     * @param structure исходный массив подразделений
     */
    public void departmentSplit(ArrayList<String> departments, ArrayList<String> parents, String[] structure) {
        for (int i = 0; i < structure.length; i++) {
            String[] parts = structure[i].split("\\\\");
            String departmentPath = "";
            String parentPath = "";
            for (int j = 0; j < parts.length; j++) {
                parentPath = departmentPath;
                if (departmentPath == "") {
                   departmentPath = parts[j];
                } else {
                    departmentPath = departmentPath + "\\" + parts[j];
                }
                if (!departments.contains(departmentPath)) {
                    departments.add(departmentPath);
                    if (j != 0) {
                        parents.add(parentPath);
                    } else {
                        parents.add("");
                    }
                }
            }
        }
    }

    /**
    * Запускаем рекурсивную сортировку по дереву департаментов
    * Преобразовываем список в массив с результатом
    * @param structure исходный массив подразделений
    * @param asc по возрастанию/по убыванию
    */
    public String[] sort(String[] structure, boolean asc) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> departments = new ArrayList<>();
        ArrayList<String> parents = new ArrayList<>();
        departmentSplit(departments, parents, structure);
        treeSort("", parents, departments, result, asc);
        String[] sortedDepartments = new String[departments.size()];
        result.toArray(sortedDepartments);
        return sortedDepartments;
    }

    /**
     * Сортировка пузырком дочерних отделов относительно родителя по возрастанию
     * @param child массив дочерних подразделений
     */
    public ArrayList<String> bubbleSortAsc(ArrayList<String> child) {
        for (int i = child.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (child.get(j).compareTo(child.get(j + 1)) > 0) {
                    String temp = child.get(j);
                    child.set(j, child.get(j + 1));
                    child.set(j + 1, temp);
                }
            }
        }
        return child;
    }

    /**
     * Сортировка пузырком дочерних отделов относительно родителя по убыванию
     * @param child массив дочерних подразделений
     */
    public ArrayList<String> bubbleSortDesc(ArrayList<String> child) {
        for (int i = child.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (child.get(j).compareTo(child.get(j + 1)) < 0) {
                    String temp = child.get(j);
                    child.set(j, child.get(j + 1));
                    child.set(j + 1, temp);
                }
            }
        }
        return child;
    }

    /**
     * Сортировка департаментов
     * Сортируем потомков по возрастанию или убыванию
     * Каждого потомка добавляем в результат и повторяем сортировку для его потомков
     * @param asc по возрастанию/по убыванию
     * @param departments список подразделений
     * @param parent подразделения(полный путь)
     * @param parents список родительских отделов
     * @param result результат
     */
    public void treeSort(String parent, ArrayList<String> parents, ArrayList<String> departments, ArrayList<String> result, boolean asc) {
        ArrayList<String> children = new ArrayList<String>();
        for (int i = 0; i < parents.size(); i++) {
           if (parent.compareTo(parents.get(i)) == 0) {
               children.add(departments.get(i));
           }
        }
        if (children.size() == 0) {
            return;
        }
        children = asc ? bubbleSortAsc(children) : bubbleSortDesc(children);
        for (String child : children) {
            result.add(child);
            treeSort(child, parents, departments, result, asc);
        }
    }
}
