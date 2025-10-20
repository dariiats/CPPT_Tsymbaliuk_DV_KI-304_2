package LAB_06;

import LAB_06.Interface.Stuff;

/**
 * Main class for Lab 6 demonstration.
 * <p>
 * This program demonstrates how to use a parameterized class {@link Jar}
 * that can store different types of objects (e.g., candies and buttons).
 * It shows how to add elements to the jar, display its contents,
 * and find the smallest element (by weight or size).
 * </p>
 *
 * <p><b>Author:</b> Daria Tsymbaliuk<br>
 * <b>Group:</b> KI-304<br>
 * <b>Version:</b> 1.0</p>
 */
public class Lab6TsymbaliukKI304 {

    /**
     * Entry point of the program.
     * <p>
     * The method creates two {@link Jar} objects:
     * one for storing candies and another for buttons.
     * It adds elements to each jar, prints all stored items,
     * and finds the smallest element in each collection.
     * </p>
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // ---------------- Candy Jar ----------------
        Jar<Stuff> candyJar = new Jar<>();

        // Adding candies to the jar
        candyJar.addStuff(new Candy("Caramel", 5));
        candyJar.addStuff(new Candy("Toffee", 8));
        candyJar.addStuff(new Candy("Chocolate", 25));

        // Displaying all candies
        candyJar.showAllStuff();

        // Finding the smallest candy
        System.out.println("\nSmallest candy:");
        Stuff minCandy = candyJar.findMin();
        if (minCandy != null)
            minCandy.print();

        System.out.println();

        // ---------------- Button Jar ----------------
        Jar<Stuff> buttonJar = new Jar<>();

        // Adding buttons to the jar
        buttonJar.addStuff(new Button("red", 15));
        buttonJar.addStuff(new Button("blue", 8));
        buttonJar.addStuff(new Button("green", 20));

        // Displaying all buttons
        buttonJar.showAllStuff();

        // Finding the smallest button
        System.out.println("\nSmallest button:");
        Stuff minButton = buttonJar.findMin();
        if (minButton != null)
            minButton.print();
    }
}
