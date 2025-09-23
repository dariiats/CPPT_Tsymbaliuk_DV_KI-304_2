package LAB_02;

import java.io.FileNotFoundException;

/**
 * Driver class to test and demonstrate the functionality of the Shlupka class.
 * It creates boats with default and custom configurations, performs various actions,
 * and logs all activity to the corresponding log files.
 */
public class Lab2TsumbaliukKI304 {

    /**
     * Main method to run the demonstration of the Shlupka class.
     *
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if log files cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Create boat with default configuration
        Shlupka boat1 = new Shlupka();

        // Display initial boat information
        boat1.boatInfo();

        //Get count oars
        boat1.getCountOars();

        //Add 1 oars
        boat1.addOars();

        //Remove 1 oars
        boat1.removeOars();

        // Load 1 passenger
        boat1.loadPassangers(1);

        //Get hull material
        boat1.getHullMaterial();

        // Attempt to unload 2 passengers (should show a warning)
        boat1.unloadPassangers(2);

        // Show remaining capacity
        boat1.passengerCapacityLeft();

        // Show current movement status
        boat1.status();

        // Start rowing
        boat1.row();

        // Stop the boat
        boat1.stop();

        // Show updated boat information
        boat1.boatInfo();

        // Close log file
        boat1.dispose();

        // Create boat with custom configuration and log file
        Shlupka boat2 = new Shlupka(6, "plastic", 8, 4, 8, "ShlupkaLog2.txt");

        // Display initial boat information
        boat2.boatInfo();

        // Load 5 passengers
        boat2.loadPassangers(5);

        // Unload 2 passengers
        boat2.unloadPassangers(2);

        // Show remaining capacity
        boat2.passengerCapacityLeft();

        // Show current movement status
        boat2.status();

        // Start rowing
        boat2.row();

        /// Show updated boat information
        boat2.boatInfo();

        // Close log file
        boat2.dispose();
    }
}
