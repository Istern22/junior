package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleOneTest {

    @Test
    public void whenTrackerSingleOne() {
        TrackerSingleOne tracker1 = TrackerSingleOne.getInstance();
        TrackerSingleOne tracker2 = TrackerSingleOne.getInstance();
        assertThat((tracker1.equals(tracker2)), is(true));
    }
}