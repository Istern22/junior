package ru.job4j.loop;

/**
 * @author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

 public class Counter {

	public int add(int start, int finish) {
		int sum = 0;

		for (int i = start; i <= finish; i = i + 1) {
			sum = sum + (i % 2 == 0 ? i : 0);
		}
		return sum;
	}
}