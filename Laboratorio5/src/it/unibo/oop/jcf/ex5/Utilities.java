package it.unibo.oop.jcf.ex5;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 */
public final class Utilities {

    private Utilities() { }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the union of the input sets.
     */
    public static <X> Set<X> setUnion(final Set<? extends X> setA, final Set<? extends X> setB) {
    	Set<X> union = new HashSet<>();
    	union.addAll(setA);
    	union.addAll(setB);
    	
        return union;
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the intersection of the input sets.
     */
    public static <X> Set<X> setIntersection(final Set<? extends X> setA, final Set<? extends X> setB) {
    	Set<X> intersection = new HashSet<>();
    	
    	intersection.addAll(setA);
    	intersection.retainAll(setB);
    	
    	return intersection;
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the symmetric difference of the input sets.
     */
    public static <X> Set<X> setSymmetricDifference(final Set<? extends X> setA, final Set<? extends X> setB) {
        Set<X> symmetricDifference = Utilities.setUnion(setA, setB);
        
        symmetricDifference.removeAll(Utilities.setIntersection(setA, setB));
        
    	return symmetricDifference;
    }

    /**
     * @param coll
     *            the collection
     * @param <X>
     *            collection type
     * @return a random element from the collection
     *
     */
    public static <X> X getRandomElement(final Collection<X> coll) {
    	Iterator<X> it = coll.iterator();
    	int index = (int) (Math.random() * coll.size()); 
    	X element = null;
    	
    	for (int i = 0; i < index; i++) {
    		it.next();
    	}
    	
    	element = it.next();
    	
        return element;
    }

    /**
     * @param first
     *            first collection
     * @param second
     *            second collection
     * @param <X>
     *            First collection type
     * @param <Y>
     *            Second collection type
     * @return a pair with two random elements
     */
    public static <X, Y> Pair<X, Y> getRandomPair(final Collection<X> first, final Collection<Y> second) {
    	X firstElement = Utilities.getRandomElement(first);
    	Y secondElement = Utilities.getRandomElement(second);
    	    	
        return new Pair<>(firstElement, secondElement);
    }
}
