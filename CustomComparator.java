/***
 * @author Vimalendu Shekhar
 * @date : 02/16/2016
 */

import java.util.Comparator;

/*
 * Custom Comparator class used to sort the input words in descending order of their lengths
 */

class CustomComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return -1;
		} else if (s1.length() < s2.length()) {
			return 1;
		}
		return s1.compareTo(s2);
	}
}