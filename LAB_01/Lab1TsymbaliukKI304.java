package LAB_01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Lab1TsymbaliukKI304 class implements a program that creates a
 * symmetrical "diamond-shaped" character matrix and outputs it to the console
 * and a file. The program asks the user for the matrix size and the filler character.
 * 
 * @author Dariia Tsymbaliuk
 * @version 1.0
 */
public class Lab1TsymbaliukKI304 {

    /**
     * Fills a 2D character array with the specified filler character.
     * 
     * @param arr 2D array to be filled
     * @param sizeArr Number of rows in the array
     * @param filler Character used for filling
     */
    static void fillArray(char arr[][], int sizeArr, String filler) {
        for (int i = 0; i < sizeArr; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = (char) filler.codePointAt(0);
            }
        }
    }

    /**
     * Initializes a 2D character array, allocating memory for each row.
     * 
     * @param arr 2D array to be initialized
     * @param sizeArr Number of rows in the array
     */
    static void MakeArr(char arr[][], int sizeArr) {
        for (int i = 0; i < sizeArr; i++) {
            arr[i] = new char[i + 1];
        }
    }

    /**
     * Main program method. Requests the matrix size and filler character,
     * constructs a symmetrical diamond-shaped matrix, and outputs it to the
     * console and a file "MyFile.txt".
     * 
     * @param args Command line arguments (not used)
     * @throws FileNotFoundException Thrown if the output file cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows = 0;           // Number of matrix rows
        char arr[][];            // 2D array for the matrix
        String filler;           // Filler character
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Ask the user for matrix size
        System.out.println("Enter size of matrix: ");
        nRows = in.nextInt();

        // Calculate half of the size for the upper part of the diamond
        int sizeArr = (int) Math.ceil(nRows / 2.0);
        arr = new char[sizeArr][];

        // Initialize the array
        MakeArr(arr, sizeArr);

        // Ask the user for the filler character
        System.out.println("Enter symbol-filler: ");
        in.nextLine(); // clear buffer
        filler = in.nextLine();

        if (filler.length() == 1) {
            fillArray(arr, sizeArr, filler);

            int n = 2;

            System.out.println("Your matrix with size " + nRows + " and made of characters " + filler);

            // Print upper part of the diamond
            for (int i = 0; i < sizeArr; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }

                // Spaces between two halves of the diamond
                for (int j = nRows - n; j > 0; j--) {
                    System.out.print(" ");
                    fout.print(" ");
                }
                n = n + 2;

                for (int j = 0; j < i + 1; j++) {
                    if ((j == sizeArr - 1) && (nRows % 2 != 0))
                        break;
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }

                System.out.println();
                fout.print("\n");
            }

            n = (nRows % 2 == 0) ? 2 : 1;

            // Print lower part of the diamond
            for (int i = (nRows % 2 == 0) ? (sizeArr - 1) : (sizeArr - 2); i >= 0; i--) {

                for (int j = 0; j < i + 1; j++) {
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }

                if (i <= (sizeArr - 2)) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(" ");
                        fout.print(" ");
                    }
                    n = n + 2;
                }

                for (int j = 0; j < i + 1; j++) {
                    if ((j == sizeArr - 1) && (nRows % 2 != 0))
                        break;
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }

                System.out.println();
                fout.print("\n");
            }
        }

        else if (filler.length() == 0) {
            System.out.print("\nYou didn't enter a filler character");
        }

        else {
            System.out.print("\nToo many characters entered for filler");
        }

        // Close resources
        fout.close();
        in.close();
    }
}
