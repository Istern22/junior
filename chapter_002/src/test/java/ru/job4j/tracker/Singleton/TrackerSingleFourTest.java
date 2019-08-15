package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleFourTest {

    @Test
    public void whenTrackerSingleFour() {
        TrackerSingleFour tracker1 = TrackerSingleFour.INSTANCE;
        TrackerSingleFour tracker2 = TrackerSingleFour.INSTANCE;
        assertThat((tracker1.equals(tracker2)), is(true));
    }
}