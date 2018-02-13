package ru.job4j.array;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {

    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        for ( int i = 1; i <= bound; i++ ) {
           rsl[i - 1] = i * i;
        }
        return rsl;
    }
}
