package LAB_05;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The {@code Lab5TsymbaliukKi304} class serves as the main testing program
 * for the {@link CalcWFio} class. It demonstrates how to perform a
 * mathematical calculation, save the result to text and binary files,
 * and then read the results back from those files.
 * <p>
 * The program requests user input from the console, performs a calculation
 * using the {@code CalcWFio.calculate()} method, and displays results
 * both from console computation and from files to verify correctness
 * of file I/O operations.
 * </p>
 *
 * <p><b>Program workflow:</b></p>
 * <ol>
 *   <li>Prompt the user to enter a numeric value.</li>
 *   <li>Compute the result using {@code CalcWFio.calculate()}.</li>
 *   <li>Display the calculated result on the console.</li>
 *   <li>Save the result to text and binary files.</li>
 *   <li>Read and display the results from both files.</li>
 * </ol>
 *
 * <p><b>Example of execution:</b></p>
 * <pre>
 * Enter data: 30
 * Result from console is: -2.00000
 * Result from .txt is: -2.00000
 * Result from .bin is: -2.00000
 * </pre>
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
public class Lab5TsymbaliukKi304 {

    /**
     * The entry point of the program.
     * <p>
     * This method creates an instance of {@link CalcWFio}, reads a value from
     * the user, performs a calculation, writes the result to text and binary
     * files, and then reads the data back to validate the correctness of
     * input/output operations.
     * </p>
     *
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if a file cannot be created or found
     * @throws IOException if an I/O error occurs during file operations
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);

        System.out.print("Enter data: ");
        double data = s.nextDouble();

        obj.calculate(data);
        System.out.println("Result from console is: " + obj.getResult());

        // Write results to files
        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");

        // Read and display results from both files
        obj.readResBin("BinRes.bin");
        System.out.println("Result from .bin is: " + obj.getResult());

        obj.readResTxt("textRes.txt");
        System.out.println("Result from .txt is: " + obj.getResult());

        s.close();
    }
}
