package ru.job4j.singleton;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleThree {

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();
    }
}
