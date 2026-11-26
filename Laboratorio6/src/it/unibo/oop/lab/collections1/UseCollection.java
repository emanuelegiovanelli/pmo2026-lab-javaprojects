package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int MIN_RANGE = 1_000;
	private static final int MAX_RANGE = 2_000;
	private static final int N_ELEMENTS = 100_000;
	private static final int N_READS = 1_000;
    private static final int TO_MS = 1_000_000;
    private static final long AFRICA_POP = 1_110_635_000;
    private static final long AMERICAS_POP = 972_005_000;
    private static final long ANTARCTICA_POP = 0;
    private static final long ASIA_POP = 4_298_723_000L;
    private static final long EUROPE_POP = 742_452_000;
    private static final long OCEANIA_POP = 38_304_000;



	
    private UseCollection() {
    }
    
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> numbers1 = new ArrayList<>();
        
        for (int i = MIN_RANGE; i < MAX_RANGE; i++) {
        	numbers1.add(i);
        }
        
        System.out.println(numbers1);
    	/*
         * 
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        
        final List<Integer> numbers2 = new LinkedList<>();
        numbers2.addAll(numbers1);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        
        Integer tmp = numbers1.getFirst();
        numbers1.set(0, numbers1.getLast());
        numbers1.set(numbers1.size() - 1, tmp);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        
        for (Integer el : numbers1) {
        	System.out.println(el);
        }
        
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
        long time = System.nanoTime();
        
        for (int i = 0; i < N_ELEMENTS; i++) {
        	numbers1.add(0, i);
        }
        
        time = System.nanoTime() - time;
        System.out.println("Inserting " + N_ELEMENTS
                + " elements as first element to an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        long time1 = System.nanoTime();
        
        for (int i = 0; i < N_ELEMENTS; i++) {
        	numbers2.add(0, i);
        }
        
        time1 = System.nanoTime() - time1;
        System.out.println("Inserting " + N_ELEMENTS
                + " elements as first element to an LinkedLIst took " + time1
                + "ns (" + time1 / TO_MS + "ms)");
        
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        long time2 = System.nanoTime();
        Integer position = numbers1.size() / 2;
        
        for (int i = 0; i < N_READS; i++) {
        	Integer itemRead = numbers1.get(position);
        }
        
        time2 = System.nanoTime() - time2;
        
        System.out.println("Reading " + N_READS
                + " times an element in the middle of an ArrayList took " + time2
                + "ns (" + time2 / TO_MS + "ms)");
        
        long time3 = System.nanoTime();
        
        Integer position1 = numbers2.size() / 2;
        
        for (int i = 0; i < N_READS; i++) {
        	Integer itemRead1 = numbers2.get(position1);
        }
        
        time3 = System.nanoTime() - time3;
        
        System.out.println("Reading " + N_READS
                + " times an element in the middle of an LinkedList took " + time3
                + "ns (" + time3 / TO_MS + "ms)");
        
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        Map<String, Long> populationPerContinent = new HashMap<>();
        populationPerContinent.put("Africa", AFRICA_POP);
        populationPerContinent.put("Americas", AMERICAS_POP);
        populationPerContinent.put("Antarctica", ANTARCTICA_POP);
        populationPerContinent.put("Asia", ASIA_POP);
        populationPerContinent.put("Europe", EUROPE_POP);
        populationPerContinent.put("Oceania", OCEANIA_POP);

        /*
         * 8) Compute the population of the world
         */
        Long populationOfTheWorld = 0L;
        for (Long value : populationPerContinent.values()) {
        	populationOfTheWorld += value;
        }
        System.out.println("The population of the world is: " + populationOfTheWorld);
    }
}
