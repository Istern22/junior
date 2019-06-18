package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class DepartmentSortTest {

    @Test

    public void resultOfSortAscendingIT() {
        DepartmentSort departmentSort = new DepartmentSort();
        String[] notSortedDepartments = {
                "IT\\злые программисты\\грустные юниоры",
                "IT\\админы",
                "Маркетинговый отдел\\маркетологи",
                "Маркетинговый отдел\\дизайнеры",
                "IT\\злые программисты\\веселые миддлы"
        };
        String[] sortedDepartments = departmentSort.sort(notSortedDepartments, true);
        String[] expectedDepartments = {
                "IT",
                "IT\\админы",
                "IT\\злые программисты",
                "IT\\злые программисты\\веселые миддлы",
                "IT\\злые программисты\\грустные юниоры",
                "Маркетинговый отдел",
                "Маркетинговый отдел\\дизайнеры",
                "Маркетинговый отдел\\маркетологи"
        };
        assertThat(sortedDepartments, is(expectedDepartments));
    }


    @Test

    public void resultOfSortDescendingIT() {
        DepartmentSort departmentSort = new DepartmentSort();
        String[] notSortedDepartments = {
                "IT\\злые программисты\\грустные юниоры",
                "IT\\админы",
                "Маркетинговый отдел\\маркетологи",
                "Маркетинговый отдел\\дизайнеры",
                "IT\\злые программисты\\веселые миддлы"
        };
        String[] sortedDepartments = departmentSort.sort(notSortedDepartments, false);
        String[] expectedDepartments = {
                "Маркетинговый отдел",
                "Маркетинговый отдел\\маркетологи",
                "Маркетинговый отдел\\дизайнеры",
                "IT",
                "IT\\злые программисты",
                "IT\\злые программисты\\грустные юниоры",
                "IT\\злые программисты\\веселые миддлы",
                "IT\\админы"
        };
        assertThat(sortedDepartments, is(expectedDepartments));
    }

    @Test

    public void resultOfSortAscendingDEP() {
        DepartmentSort departmentSort = new DepartmentSort();
        String[] notSortedDepartments = {
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5\\DEP6\\DEP7\\DEP8\\DEP9"
        };
        String[] sortedDepartments = departmentSort.sort(notSortedDepartments, true);
        String[] expectedDepartments = {
                "DEP1",
                "DEP1\\DEP2",
                "DEP1\\DEP2\\DEP3",
                "DEP1\\DEP2\\DEP3\\DEP4",
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5",
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5\\DEP6",
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5\\DEP6\\DEP7",
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5\\DEP6\\DEP7\\DEP8",
                "DEP1\\DEP2\\DEP3\\DEP4\\DEP5\\DEP6\\DEP7\\DEP8\\DEP9"
        };
        assertThat(sortedDepartments, is(expectedDepartments));
    }

    @Test

    public void resultOfSortAscendingK() {
        DepartmentSort departmentSort = new DepartmentSort();
        String[] notSortedDepartments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] sortedDepartments = departmentSort.sort(notSortedDepartments, true);
        String[] expectedDepartments = {
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        assertThat(sortedDepartments, is(expectedDepartments));
    }

    @Test

    public void resultOfSortDescendingK() {
        DepartmentSort departmentSort = new DepartmentSort();
        String[] notSortedDepartments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] sortedDepartments = departmentSort.sort(notSortedDepartments, false);
        String[] expectedDepartments = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        assertThat(sortedDepartments, is(expectedDepartments));
    }
}
