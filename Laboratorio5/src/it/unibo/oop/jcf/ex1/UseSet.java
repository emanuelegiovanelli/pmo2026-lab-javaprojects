package it.unibo.oop.jcf.ex1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example class using {@link Set}.
 * 
 */
public final class UseSet {

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         * 
         * 1) Builds a TreeSet containing Strings
         * 
         * 2) Populates such Collection with all the Strings ranging from "1" to
         * "20"
         * 
         * 3) Prints its content
         * 
         * 4) Removes all those strings whose represented number is divisible by
         * three
         * 
         * 5) Prints the content of the Set using a for-each costruct
         * 
         * 6) Verifies if all the numbers left in the set are even
         */
    	
    	Set<String> strings = new TreeSet<>();
    	
    	for (int i = 0; i < 20; i++) {
    		strings.add(String.valueOf(i));
    	}
    	
    	System.out.println(strings);
    	
    	Iterator<String> it = strings.iterator();
    	
    	while (it.hasNext()) {
    		
    		if (Integer.parseInt(it.next()) % 3 == 0) {
    			it.remove();
    		}
    	}
    	
    	
    	for (String s : strings) {
    		System.out.print(s + " ");
    	}
    	
    	boolean areAllEven = true;
    	for (String s : strings) {
    		if (!(Integer.parseInt(s) % 2 == 0)) {
    			areAllEven = false;
    		}
    	}
    	
    	System.out.println();
    	System.out.println(areAllEven);
    }
}
