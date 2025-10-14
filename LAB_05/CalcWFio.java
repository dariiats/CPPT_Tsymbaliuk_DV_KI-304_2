package LAB_05;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The {@code CalcWFio} class provides methods for performing calculations
 * and saving/reading the results in both text and binary file formats.
 * <p>
 * The calculation result is stored in the private field {@code result}.
 * The class offers functionality to write this value to a file
 * (in text or binary format) and to read it back from the file.
 * </p>
 * <p>
 * The class uses Java I/O streams such as {@link DataOutputStream},
 * {@link DataInputStream}, {@link PrintWriter}, and {@link Scanner}
 * for file operations.
 * </p>
 *
 * <p><b>Example of usage:</b></p>
 * <pre>
 * CalcWFio calc = new CalcWFio();
 * calc.calculate(45);
 * calc.writeResTxt("Result.txt");
 * calc.writeResBin("Result.bin");
 * calc.readResTxt("Result.txt");
 * System.out.println("Result: " + calc.getResult());
 * </pre>
 *
 * @author Daria Tsymbaliuk
 * @version 1.0
 */
class CalcWFio {

    /** The result of the last calculation. */
    private double result;

    /**
     * Writes the result to a text file.
     *
     * @param fName the name of the output file
     * @throws FileNotFoundException if the specified file cannot be created or opened
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f", result);
        f.close();
    }

    /**
     * Reads the result value from a text file.
     *
     * @param fName the name of the input file
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("File " + fName + " not found");
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * Writes the result value to a binary file.
     *
     * @param fName the name of the binary output file
     * @throws IOException if an I/O error occurs while writing
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads the result value from a binary file.
     *
     * @param fName the name of the binary input file
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException if an I/O error occurs while reading
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Performs a mathematical calculation using the {@link Equations} class.
     * The resulting value is stored in the {@code result} field.
     *
     * @param x the input value for the calculation
     */
    public void calculate(double x) {
        Equations eq = new Equations();
        result = eq.calculate(x);
    }

    /**
     * Returns the last calculated result.
     *
     * @return the current value of {@code result}
     */
    public double getResult() {
        return result;
    }
}
