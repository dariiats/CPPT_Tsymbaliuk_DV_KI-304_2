package LAB_06;

import LAB_06.Interface.Stuff;

/**
 * The {@code Button} class represents a button object that can be stored
 * inside a {@link Jar}. Each button has a color and a diameter in millimeters.
 * <p>
 * This class implements the {@link Stuff} interface,
 * which allows buttons to be compared by their diameter.
 * </p>
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
public class Button implements Stuff {

    /** The color of the button. */
    private String color;

    /** The diameter of the button in millimeters. */
    private int diameter;

    /**
     * Constructs a new {@code Button} object with the specified color and diameter.
     *
     * @param color    the color of the button
     * @param diameter the diameter of the button in millimeters
     */
    public Button(String color, int diameter) {
        this.color = color;
        this.diameter = diameter;
    }

    /**
     * Returns the size of the button, which in this case
     * corresponds to its diameter in millimeters.
     *
     * @return the diameter of the button
     */
    @Override
    public int getSize() {
        return diameter;
    }

    /**
     * Compares this button to another {@link Stuff} object based on their sizes.
     * The comparison is done by diameter.
     *
     * @param other another {@link Stuff} object to compare with
     * @return a negative value if this button is smaller,
     *         zero if equal in diameter,
     *         or a positive value if larger
     */
    @Override
    public int compareTo(Stuff other) {
        return Integer.compare(this.getSize(), other.getSize());
    }

    /**
     * Prints the button's information (color and diameter) to the console.
     */
    @Override
    public void print() {
        System.out.println("Button: " + color + ", diameter: " + diameter + " mm");
    }
}
