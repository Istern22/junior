package ru.job4j.array;

import java.lang.String;
import java.util.ArrayList;

public class DepartmentSort {

    public void departmentSplit(ArrayList<String> departments, ArrayList<String> parents, String[] departmentStructure) {
        // Проходим по каждому элементу массива, разбиваем его на части
        for (int i = 0; i < departmentStructure.length; i++) {
            String[] depParts = departmentStructure[i].split("\\\\");
            // Вспомогательные строки для записи пути департамента и родителя
            String pathToDepartment = "";
            String pathToParent = "";
            // Вычисляем путь до подразделения(включительно) и до родителя(не включая сам элемент)
            // Если такой путь не содержится в массиве подразделений, то добавляем путь и его родителя
            // Таким образом будут добавлены недостающие элементы дерева
            // Нужно добавлять полный путь, чтобы потом по нему сортировать
            // Нужно добавлять полный путь до родителя, чтобы различать путь через одинаковые промежуточные элементы
            for (int j = 0; j < depParts.length; j++) {
                pathToParent = pathToDepartment;
                if (pathToDepartment == "") {
                    pathToDepartment = depParts[j];
                } else {
                    pathToDepartment = pathToDepartment + "\\" + depParts[j];
                }
                if (!departments.contains(pathToDepartment)) {
                    departments.add(pathToDepartment);
                    if (j != 0) {
                        parents.add(pathToParent);
                    } else {
                        parents.add("");
                    }
                }
            }
        }
    }

    public String[] sort(String[] departmentStructure, boolean ASC) {
        //Новый список для записи результата
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> departments = new ArrayList<>();
        ArrayList<String> parents = new ArrayList<>();
        departmentSplit(departments, parents, departmentStructure);
        //Запускаем рекурсивную сортировку по дереву департаментов
        treeSort("", parents, departments, result, ASC);
        //Преобразовываем список в массив с результатом
        String[] sortedDepartments = new String[departments.size()];
        result.toArray(sortedDepartments);
        return sortedDepartments;
    }
    //Сортировка пузырком дочерних отделов относительно родителя по возрастанию
    public ArrayList <String> bubbleSortACS(ArrayList <String> childSort) {

        for (int i = childSort.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (childSort.get(j).compareTo(childSort.get(j + 1)) > 0) {
                    String temp = childSort.get(j);
                    childSort.set(j, childSort.get(j + 1));
                    childSort.set(j + 1, temp);
                }
            }
        }
        return childSort;
    }
    //Сортировка пузырком дочерних отделов относительно родителя по убыванию
    public ArrayList <String> bubbleSortDESC(ArrayList <String> childSort) {
        for (int i = childSort.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (childSort.get(j).compareTo(childSort.get(j + 1)) < 0) {
                    String temp = childSort.get(j);
                    childSort.set(j, childSort.get(j + 1));
                    childSort.set(j + 1, temp);
                }
            }
        }
        return childSort;
    }
    //Сортировка департаментов
    //На входе переменная подразделения(полный путь), потомков которого сортируем, список родительских отделов, список подразделений, результат, логическая перменная,
    // по которой определяем, сортируем по возрастанию или убыванию
    public void treeSort(String parent, ArrayList<String> parents, ArrayList<String> departments, ArrayList<String> result, boolean ASC) {
        //Создаем список потомков от подразделения
        ArrayList<String> children = new ArrayList<String>();
        for (int i = 0; i < parents.size(); i++) {
           if (parent.compareTo(parents.get(i)) == 0) {
               children.add(departments.get(i));
           }
        }
        if (children.size() == 0) {
            return;
        }
        //Сортируем потомков по возрастанию или убыванию
        children = ASC ? bubbleSortACS(children) : bubbleSortDESC(children);
        //Каждого потомка добавляем в результат и повторяем сортировку для его потомков
        for (String child : children) {
            result.add(child);
            treeSort(child, parents, departments, result, ASC);
        }
    }
}
