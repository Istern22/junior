package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

 public class MaxTest {
	@Test
	public void whenFirstLessSecond() {
		Max maximum = new Max();
		int result = maximum.max(1, 2);
		assertThat(result, is(2));
	}

	@Test
	public void whenSecondLessFirst() {
		Max maximum = new Max();
		int result = maximum.max(2, 1);
		assertThat(result, is(2));
	}
}