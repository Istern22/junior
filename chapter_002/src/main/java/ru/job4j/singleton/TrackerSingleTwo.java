package ru.job4j.singleton;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleTwo {

    private static final TrackerSingleTwo INSTANCE = new TrackerSingleTwo();

    private TrackerSingleTwo() {
    }

    public static TrackerSingleTwo getInstance() {
        return INSTANCE;
    }

}
