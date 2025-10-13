package LAB_04;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class <code>Lab4TsymbaliukKI304</code> is the driver class for testing
 * the {@link Equations} class.
 * <p>
 * It requests input from the user, performs the calculation
 * of the expression y = 1 / cos(4x) using the {@link Equations} class,
 * and writes the result into a text file.
 * </p>
 * <p>
 * The class demonstrates the use of exception handling in Java,
 * including custom exceptions (CalcException) and file-related exceptions.
 * </p>
 * 
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
public class Lab4TsymbaliukKI304 
{
    /**
     * Main method of the program.
     * <p>
     * It asks the user for a file name and a numeric value of x,
     * calculates the result of the expression y = 1 / cos(4x),
     * and writes it into the specified file.
     * </p>
     * <p>
     * The method demonstrates nested try-catch-finally blocks for
     * handling arithmetic and file-related exceptions.
     * </p>
     *
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if the output file cannot be created or opened
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        try
        {
            System.out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fname = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fname));

            try
            {
                try
                {
                    Equations eq = new Equations();
                    System.out.print("Enter X: ");
                    int x = in.nextInt();
                    fout.println(eq.calculate(x));
                }

                finally
                {
                    // This block executes under any circumstances
                    fout.flush(); // Ensure all data is written to the file
                    fout.close(); // Close the file writer
                    in.close();   // Close the scanner to free system resources
                }
            }

            catch(CalcException ex)
            {
                // This block catches calculation-related exceptions
                System.out.print(ex.getMessage());
            }
        }

        catch(FileNotFoundException ex)
        {
            // This block catches file operation errors
            System.out.println("Exception reason: Perhaps wrong file path");
        }
    }
}
