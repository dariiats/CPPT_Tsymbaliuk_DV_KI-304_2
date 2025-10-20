package LAB_06;

/**
 * Container class for the {@link Stuff} interface.
 * <p>
 * This interface defines the basic structure for objects
 * that can be stored inside a {@link Jar}.
 * Each object must be comparable by size and able to print its own information.
 * </p>
 *
 * <p><b>Author:</b> Daria Tsymbaliuk<br>
 * <b>Group:</b> KI-304<br>
 * <b>Version:</b> 1.0</p>
 */
public class Interface {

    /**
     * The {@code Stuff} interface defines the contract for any object
     * that can be placed inside a {@link Jar}. Implementing classes
     * must provide a way to:
     * <ul>
     *     <li>return their size (weight, diameter, etc.),</li>
     *     <li>compare themselves to other {@code Stuff} objects,</li>
     *     <li>and print their information to the console.</li>
     * </ul>
     */
    public interface Stuff extends Comparable<Stuff> {

        /**
         * Returns the size of the object.
         * The meaning of "size" depends on the specific implementation
         * (e.g., weight for candies, diameter for buttons).
         *
         * @return integer value representing the object's size
         */
        int getSize();

        /**
         * Prints information about the object to the console.
         * Each class that implements {@code Stuff} defines its own print format.
         */
        void print();
    }
}
