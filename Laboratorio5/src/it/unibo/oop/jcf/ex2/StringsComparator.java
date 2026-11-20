package it.unibo.oop.jcf.ex2;

import java.util.Comparator;


public class StringsComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		return Double.compare(Double.parseDouble(s1), Double.parseDouble(s2));
	}
}
