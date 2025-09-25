package LAB_03;

import java.io.FileNotFoundException;
import LAB_03.interfaces.Flue;
import LAB_03.interfaces.Powered;

/**
 * Class MotorBoat extends the abstract ShlupkaAbs and represents a motorized boat.
 * It implements the Powered and Flue interfaces to manage engine operations and fuel.
 */
public class motorBoat extends ShlupkaAbs implements Flue, Powered {

    /** Indicates whether the engine is running. */
    private boolean engineRunning;

    /** Amount of fuel in liters. */
    private double fuelLiters;

    /**
     * Default constructor. Creates a MotorBoat with engine off and zero fuel.
     * 
     * @throws FileNotFoundException if the log file cannot be created
     */
    public motorBoat() throws FileNotFoundException {
        engineRunning = false;
        fuelLiters = 0;
    }

    /**
     * Constructor with parameters to create a MotorBoat with specific configuration.
     * 
     * @param countOars number of oars
     * @param material hull material
     * @param length hull length in meters
     * @param width hull width in meters
     * @param countSeats number of seats
     * @param nameFile name of the log file
     * @param engineRunning initial engine state
     * @param fuelLiters initial fuel amount
     * @param speedMS initial speed in meters per second (not used in this example)
     * @throws FileNotFoundException if the log file cannot be created
     */
    public motorBoat(int countOars, String material, double length,
                     double width, int countSeats, String nameFile,
                     boolean engineRunning, double fuelLiters, double speedMS) throws FileNotFoundException {
        super(countOars, material, length, width, countSeats, nameFile);
        this.fuelLiters = fuelLiters;
        this.engineRunning = engineRunning;
    }

    /**
     * Moves the boat a specified distance if the engine is running and there is enough fuel.
     * Consumes 1 liter of fuel per meter moved.
     * 
     * @param distanceMetres distance to move in meters
     */
    @Override
    public void moveBoat(double distanceMetres) {
        if (fuelLiters != 0 && distanceMetres <= fuelLiters && engineRunning) {
            fuelLiters -= distanceMetres;
            fout.println("Boat moved " + distanceMetres + " meters. Remaining fuel: " + fuelLiters);
        } else if (!engineRunning) {
            fout.println("Cannot move. Engine is off!");
        } else {
            fout.println("Cannot move. Not enough fuel!");
        }
    }

    /**
     * Starts the boat's engine.
     */
    @Override
    public void startEngine() {
        engineRunning = true;
        fout.println("Engine turned on!");
    }

    /**
     * Stops the boat's engine.
     */
    @Override
    public void stopEngine() {
        engineRunning = false;
        fout.println("Engine turned off!");
    }

    /**
     * Prints the current fuel level to the log file.
     */
    @Override
    public void checkFlue() {
        fout.println("Remaining fuel: " + fuelLiters);
    }

    /**
     * Refuels the boat by a specified amount.
     * 
     * @param countFlue amount of fuel to add in liters
     */
    @Override
    public void Refueling(double countFlue) {
        fuelLiters += countFlue;
        fout.println("Boat refueled. Current fuel: " + fuelLiters);
    }

    /**
     * Prints full information about the boat including engine state and fuel level.
     */
    @Override
    public void boatInfo() {
        super.boatInfo();
        fout.println("Engine running: " + (engineRunning ? "Yes" : "No"));
        fout.println("Fuel liters: " + fuelLiters);
    }
}
