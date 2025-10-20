package LAB_06;

import LAB_06.Interface.Stuff;
import java.util.ArrayList;

/**
 * Generic class {@code Jar} represents a container that can store
 * different kinds of objects implementing the {@link Stuff} interface.
 * <p>
 * This class demonstrates the use of Java Generics with type restriction.
 * It provides basic operations such as adding, removing, displaying items,
 * and finding the smallest element (according to {@link Comparable} order).
 * </p>
 *
 * @param <T> the type of elements stored in the jar, must implement {@link Stuff}
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
public class Jar<T extends Stuff> {

    /** List that holds all elements placed in the jar. */
    private ArrayList<T> arr;

    /**
     * Default constructor that initializes an empty jar.
     */
    public Jar() {
        arr = new ArrayList<T>();
    }

    /**
     * Finds and returns the smallest element in the jar.
     * <p>
     * If the jar is empty, the method returns {@code null}.
     * </p>
     *
     * @return the smallest element in the jar or {@code null} if empty
     */
    public T findMin() {
        if (arr.isEmpty()) return null;

        T min = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).compareTo(min) < 0) {
                min = arr.get(i);
            }
        }
        return min;
    }

    /**
     * Adds a new element to the jar and prints confirmation to the console.
     *
     * @param stuff the element to be added to the jar
     */
    public void addStuff(T stuff) {
        arr.add(stuff);
        System.out.print("Element added: ");
        stuff.print();
    }

    /**
     * Removes a specified element from the jar (if it exists)
     * and prints confirmation to the console.
     *
     * @param stuff the element to be removed
     */
    public void removeStuff(T stuff) {
        arr.remove(stuff);
        System.out.print("Element removed: ");
        stuff.print();
    }

    /**
     * Displays all elements currently stored in the jar.
     * Each element’s {@code print()} method is called.
     */
    public void showAllStuff() {
        System.out.println("Contents of the jar:");
        for (T item : arr)
            item.print();
    }
}
