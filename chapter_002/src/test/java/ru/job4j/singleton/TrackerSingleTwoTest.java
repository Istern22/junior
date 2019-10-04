package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleTwoTest {

    @Test
    public void whenTrackerSingleTwo() {
        TrackerSingleTwo tracker1 = TrackerSingleTwo.getInstance();
        TrackerSingleTwo tracker2 = TrackerSingleTwo.getInstance();
        assertThat((tracker1.equals(tracker2)), is(true));
    }
}