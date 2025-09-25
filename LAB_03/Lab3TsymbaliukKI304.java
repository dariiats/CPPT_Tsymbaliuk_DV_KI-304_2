package LAB_03;

import java.io.FileNotFoundException;

/**
 * The Lab3TsymbaliukKI304 class demonstrates the functionality of the MotorBoat subclass,
 * which extends the abstract ShlupkaAbs class and implements the Powered and Flue interfaces.
 * The program shows creating a boat, controlling the engine, moving with oars, and logging the state.
 */
public class Lab3TsymbaliukKI304 {

    /**
     * The main method runs the demonstration of the MotorBoat operations.
     * 
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if the log file cannot be created
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Creating an instance of MotorBoat
        motorBoat boat = new motorBoat(); 

        // Display initial boat information
        boat.boatInfo();

        // Engine operations: start, refuel, move, stop
        boat.startEngine();
        boat.Refueling(10);
        boat.moveBoat(5);
        boat.stopEngine();
        boat.checkFlue();

        // Passenger operations: load passengers, row, stop
        boat.loadPassangers(3);
        boat.row();
        boat.stop();

        // Display final boat information
        boat.boatInfo();

        // Close the log file and release resources
        boat.dispose();
    }
}
