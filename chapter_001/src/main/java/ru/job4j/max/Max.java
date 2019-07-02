package ru.job4j.max;
/**
 *@author Svetlana Ragulina (alistern22@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {
	
	public int max(int first, int second) {
		return first > second ? first : second;
	}

	public int max(int first, int second, int third) {
		return  max(first, max(second, third));
	}

	public int max(int first, int second, int third, int four) {
		return  max(first, max(second, max(third, four)));
	}
}