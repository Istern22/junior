package ru.job4j.reader;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NumberReaderTest {

    NumberReader reader = new NumberReader();

    @Test
    public void whenSingleNumbers() {
        assertThat(reader.convert("девять нуль три шесть два восемь ноль единица четверка двойка"), is(9036280142L));
    }

    @Test
    public void whenAddTwoDigitNumbersUpToTwenty() {
        assertThat(reader.convert("двойка одиннадцать ноль девятнадцать тринадцать двенадцать"), is(2110191312L));
    }

    @Test
    public void whenAddTwoDigitNumbers() {
        assertThat(reader.convert("двойка одиннадцать ноль девяносто девять двадцать два семьдесят восемь"), is(2110992278L));
    }

    @Test
    public void whenAddTwoDigitNumbers2() {
        assertThat(reader.convert("семьдесят двойка одиннадцать ноль девяносто девять двадцать два"), is(7021109922L));
    }

    @Test
    public void whenAddThreeDigitNumbers() {
        assertThat(reader.convert("девятьсот девяносто девять двойка нуль сто двадцать один восемнадцать"), is(9992012118L));
    }

    @Test
    public void whenAddThreeDigitNumbers2() {
        assertThat(reader.convert("сотня двести пять три сотни единица"), is(1002053001L));
    }

    @Test
    public void whenAddFourDigitNumbers() {
        assertThat(reader.convert("десять тысяч триста сорок девять нуль нуль единица два три"), is(1034900123L));
    }

    @Test
    public void whenAddFiveDigitNumbers() {
        assertThat(reader.convert("семнадцать тысяч пятьсот тридцать единица три нуля семь"), is(1753010007L));
    }

    @Test
    public void whenMixOfNumbers() {
        assertThat(reader.convert("один три четыре пятерка десятка сотня пятерка"), is(1345101005L));
    }

    @Test
    public void whenMixOfNumbers2() {
        assertThat(reader.convert("одна пятерка две тройки ноль ноль двенадцать тысяч девятьсот один"), is(5330012901L));
    }

    @Test
    public void whenMixOfNumbers3() {
        assertThat(reader.convert("одна десятка три четыре сорок семь один три две девятки"), is(1034471399L));
    }

    @Test
    public void whenMixOfNumbers4() {
        assertThat(reader.convert("тысяча две девятки семнадцать двадцать"), is(1000991720L));
    }

    @Test
    public void whenMixOfNumbers5() {
        assertThat(reader.convert("три два ноль одна пятерка одна тысяча восьмерка нуль"), is(3205100080L));
    }

    @Test
    public void whenMixOfNumbers6() {
        assertThat(reader.convert("единица девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять"), is(1999999999L));
    }

    @Test
    public void whenMixOfNumbers7() {
        assertThat(reader.convert("один миллион двести восемьдесят тысяч сто единица двойка тройка"), is(1280100123L));
    }

    @Test
    public void whenOutOfBorders() {
        assertThat(reader.convert("три два ноль одна пятерка одна тысяча восьмерка сотня"), is(-1L));
    }
}