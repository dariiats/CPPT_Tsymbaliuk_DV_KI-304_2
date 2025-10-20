package LAB_06;

import LAB_06.Interface.Stuff;

/**
 * The {@code Candy} class represents a candy item that can be stored
 * inside a {@link Jar}. Each candy has a name and a weight (in grams).
 * <p>
 * This class implements the {@link Stuff} interface,
 * which allows candies to be compared by their weight.
 * </p>
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
public class Candy implements Stuff {

    /** The name of the candy. */
    private String name;

    /** The weight of the candy in grams. */
    private int weight;

    /**
     * Constructs a new {@code Candy} object with the specified name and weight.
     *
     * @param name   the name of the candy
     * @param weight the weight of the candy in grams
     */
    public Candy(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Returns the size of the candy, which in this case
     * corresponds to its weight in grams.
     *
     * @return the candy's weight
     */
    @Override
    public int getSize() {
        return weight;
    }

    /**
     * Compares this candy with another object that implements {@link Stuff}.
     * Comparison is based on weight.
     *
     * @param other another {@link Stuff} object to compare with
     * @return a negative value if this candy is smaller,
     *         zero if equal in weight,
     *         or a positive value if larger
     */
    @Override
    public int compareTo(Stuff other) {
        return Integer.compare(this.getSize(), other.getSize());
    }

    /**
     * Prints the candy's information (name and weight) to the console.
     */
    @Override
    public void print() {
        System.out.println("Candy: " + name + ", weight: " + weight + " g");
    }
}
