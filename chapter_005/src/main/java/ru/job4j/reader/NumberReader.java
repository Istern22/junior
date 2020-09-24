package ru.job4j.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс с функцией конвертации словестного представления числа в цифровой вид.
 * @author Istern22
 * @version 2.1
 */
public class NumberReader {

    /**
     * Метод преобразования словесного численного представления числа в цифрой вид.
     * @param number строковое представление десятизначного числа
     * @return цифровое представление десятизначного числа
     */
    public long convert(String number) {
        ArrayList<String> array = new ArrayList<>();
        String[] items = number.split(" ");
        for (int i = 0; i < items.length; i++) {
            array.add(items[i].toLowerCase());
        }
        ArrayList<Integer> resultArray = analyze(array);
        String string = "";
        for (var item : resultArray) {
            string += item.toString();
        }
        long result = Long.parseLong(string);
        return getCountsOfDigits(result) == 10 ? result : -1L;
    }

    /**
     * Метод обработки строкового массива в цифровой вид.
     * @param array динамический массив строк
     * @return динамический массив чисел
     */
    public ArrayList<Integer> analyze(ArrayList<String> array) {
        ArrayList<Integer> result = new ArrayList<>();
        int preDigit = 0;
        int digit = 0;
        boolean million = false;
        int index = 0;
        int number;
        for (int i = 0; i < array.size(); i++) {
            number = 0;
            if (array.get(i).endsWith("ка") || array.get(i).equals("единица")
                    || (index > 0 && (array.get(i - 1).equals("десятка") || array.get(i - 1).equals("тысяча")))) {
                preDigit = 0;
            }
            if (array.get(i).startsWith("ноль") || array.get(i).equals("нуль") || array.get(i).equals("нуля")) {
                number = 0;
            } else if (array.get(i).startsWith("один") || array.get(i).startsWith("единиц") || array.get(i).equals("одна")) {
                number = 1;
            } else if (array.get(i).startsWith("два") || array.get(i).contains("две") || array.get(i).startsWith("дво")) {
                number = 2;
            } else if (array.get(i).startsWith("три") || array.get(i).startsWith("тройк")) {
                number = 3;
            } else if (array.get(i).startsWith("четыр") || array.get(i).startsWith("четвер")) {
                number = 4;
            } else if (array.get(i).startsWith("пят") || array.get(i).startsWith("пятер")) {
                number = 5;
            } else if (array.get(i).startsWith("шест") || array.get(i).startsWith("шестер")) {
                number = 6;
            } else if (array.get(i).startsWith("сем") || array.get(i).startsWith("семер")) {
                number = 7;
            } else if (array.get(i).startsWith("восем") || array.get(i).startsWith("восьмер")) {
                number = 8;
            } else if (array.get(i).startsWith("девят")) {
                number = 9;
            } else if (array.get(i).equals("десять") || array.get(i).startsWith("десят")) {
                number = 10;
            } else if (array.get(i).equals("сорок")) {
                number = 40;
            } else if (array.get(i).equals("девяносто")) {
                number = 90;
            }
            if (array.get(i).endsWith("надцать")) {
                number += 10;
            } else if (array.get(i).endsWith("цать") || array.get(i).endsWith("десят")) {
                number *= 10;
            } else if (array.get(i).endsWith("сот") || array.get(i).endsWith("ста") || array.get(i).endsWith("сти")) {
                number *= 100;
            } else if ((array.get(i).endsWith("сто") && !array.get(i).equals("девяносто")) || array.get(i).startsWith("сотн")) {
                number = 100;
            } else if (array.get(i).startsWith("тысяч")) {
                number = 1000;
            } else if (array.get(i).startsWith("миллион")) {
                number = 1000000;
                million = true;
            }

            digit = getCountsOfDigits(number);

            if (preDigit > digit && index > 0 && result.get(index - 1).toString().endsWith("0")) {
                result.set(index - 1, result.get(index - 1) + number);
            } else if (million && number == 1000) {
                String str = result.get(index - 1).toString();
                int thousands = Integer.parseInt(str.substring(str.length() - 3));
                result.set(index - 1, result.get(index - 1) + thousands * 1000);
                result.set(index - 1, result.get(index - 1) - thousands);
            } else if (index > 0 && (array.get(i).startsWith("тысяч") || array.get(i).startsWith("миллион") || array.get(i).equals("сотни"))
                    || (index > 0 && (array.get(i - 1).equals("одна") && (array.get(i).endsWith("ка"))))) {
                result.set(index - 1, result.get(index - 1) * number);
            } else if (array.get(i).equals("ноля") || array.get(i).equals("нуля")
                    || array.get(i).endsWith("ки") || (array.get(i).endsWith("ок") && !array.get(i).endsWith("сорок"))
                    || array.get(i).equals("единицы")) {
                int repeat = result.get(index - 1);
                result.remove(index - 1);
                index--;
                for (int j = 0; j < repeat; j++) {
                    result.add(number);
                    index++;
                }
            } else {
                result.add(number);
                index++;
            }
            preDigit = digit;
        }
        return result;
    }

    /**
     * Метод определения количества цифр в числе
     * @param number число
     * @return количество цифр
     */
    public int getCountsOfDigits(long number) {
        return (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
}
