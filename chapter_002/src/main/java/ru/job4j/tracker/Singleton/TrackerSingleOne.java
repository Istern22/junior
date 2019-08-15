package ru.job4j.tracker.singleton;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public final class TrackerSingleOne {

    private static TrackerSingleOne instance;

    private TrackerSingleOne() {
    }

    public static TrackerSingleOne getInstance() {
        if (instance == null) {
            instance = new TrackerSingleOne();
        }
        return instance;
    }
}
