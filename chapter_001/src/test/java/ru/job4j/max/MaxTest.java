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
	public void whenFirstLessSecondLessThird() {
		Max maximum = new Max();
		int result = maximum.max(1, 2, 3);
		assertThat(result, is(3));
	}

	@Test
	public void whenSecondLessThirdLessFirst() {
		Max maximum = new Max();
		int result = maximum.max(2, 1, 0);
		assertThat(result, is(2));
	}

	@Test
	public void whenFirstLessThirdLessSecond() {
		Max maximum = new Max();
		int result = maximum.max(2, 3, 0);
		assertThat(result, is(3));
	}
}