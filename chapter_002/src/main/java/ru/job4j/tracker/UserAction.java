package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     * @return key
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Store tracker) throws SQLException;

    /**
     * Метод возвращает информацию о данном пункте меню
     * @return строка меню
     */
    String info();
}
