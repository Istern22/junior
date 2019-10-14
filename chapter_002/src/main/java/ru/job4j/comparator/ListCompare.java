package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;

        int fullArrayLength = Math.max(left.length(), right.length());

        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();

        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        for (int i = 0; i < fullArrayLength; i++) {
            char leftChar = i < leftLength ? leftArray[i] : ' ';
            char rightChar = i < rightLength ? rightArray[i] : ' ';
            result = Character.compare(leftChar, rightChar);
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}
