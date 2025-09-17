package LAB_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class <code>Shlupka</code> models a rowing boat with oars, hull, and seats.
 * It allows managing passengers, boat movement, and logs all actions to a file.
 */
public class Shlupka {

    private Oars oars;
    private Hull hull;
    private Seats seats;
    private int passanger;
    private boolean move;
    PrintWriter fout;

    /**
     * Default constructor. Creates a boat with default configuration:
     * 2 oars, wooden hull 6x2 meters, 6 seats, and empty log file "ShlupkaLog.txt".
     * 
     * @throws FileNotFoundException if the log file cannot be created
     */
    public Shlupka() throws FileNotFoundException {
        this.oars = new Oars();
        this.hull = new Hull();
        this.seats = new Seats();
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File("ShlupkaLog.txt"));
    }

    /**
     * Constructor with parameters to create a boat with specific configuration.
     *
     * @param countOars  number of oars
     * @param material   material of the hull
     * @param length     hull length in meters
     * @param width      hull width in meters
     * @param countSeats number of seats
     * @param nameFile   name of the log file
     * @throws FileNotFoundException if the log file cannot be created
     */
    public Shlupka(int countOars, String material, double length, double width, int countSeats, String nameFile)
            throws FileNotFoundException {
        oars = new Oars(countOars);
        hull = new Hull(material, length, width);
        seats = new Seats(countSeats);
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File(nameFile));
    }

    /**
     * Loads a specified number of passengers onto the boat.
     * Logs the action and warns if there are not enough seats.
     *
     * @param count number of passengers to load
     */
    public void loadPassangers(int count) {
        if ((count + passanger) <= seats.countSeats) {
            passanger += count;
            fout.println("Load passangers. Boat has: " + passanger + " passangers");
        } else {
            fout.println("Too many passengers. Maximum seats: " + seats.countSeats + ". Current: " + passanger);
        }
    }

    /**
     * Loads all available passengers onto the boat.
     * Logs how many passengers were boarded.
     */
    public void boardAllPassengers() {
        int availableSeats = seats.getCountSeats() - passanger;
        if (availableSeats > 0) {
            passanger += availableSeats;
            fout.println("All available passengers boarded: " + availableSeats + ". Total now: " + passanger);
        } else {
            fout.println("No available seats to board passengers. Total passengers: " + passanger);
        }
    }

    /**
     * Unloads a specified number of passengers from the boat.
     * Logs the action and warns if the boat is empty or count is invalid.
     *
     * @param count number of passengers to unload
     */
    public void unloadPassangers(int count) {
        if (passanger >= count) {
            passanger -= count;
            fout.println("Unload passangers. Boat has: " + passanger + " passangers");
        } else if (passanger == 0) {
            fout.println("Impossible unload passanger. Boat is empty!");
        } else {
            fout.println("Impossible unload this count. Boat has: " + passanger + " passangers");
        }
    }

    /**
     * Starts moving the boat if there are passengers and oars.
     * Logs the action or reason for failure.
     */
    public void row() {
        if (!move && passanger > 0 && oars.getCountOars() > 0) {
            move = true;
            fout.println("Boat starts moving with " + passanger + " passangers");
        } else if (move) {
            fout.println("Boat is already moving!");
        } else {
            fout.println("Impossible to move! Boat doesn't have passengers or oars");
        }
    }

    /**
     * Stops the boat if it is moving.
     * Logs the action or reason for failure.
     */
    public void stop() {
        if (move) {
            move = false;
            fout.println("Boat stops moving with " + passanger + " passangers");
        } else {
            fout.println("Boat already stopped!");
        }
    }

    /**
     * Prints the current movement status to the log file.
     */
    public void status() {
        fout.println("Status: " + (move ? "moving" : "not moving"));
    }

    /**
     * Prints the number of free seats available for passengers.
     */
    public void passengerCapacityLeft() {
        int left = seats.getCountSeats() - passanger;
        left = left >= 0 ? left : 0;
        fout.println("Available passenger seats: " + left);
    }

    /**
     * Prints full information about the boat's configuration and current state.
     */
    public void boatInfo() {
        fout.println("Number of oars: " + oars.getCountOars());
        fout.println("Boat material: " + hull.material);
        fout.println("Hull length: " + hull.lengthMeters);
        fout.println("Hull width: " + hull.widthMeters);
        fout.println("Seats: " + seats.countSeats);
        fout.println("Passengers: " + passanger);
        fout.println("Status: " + (move ? "moving" : "not moving"));
    }

    /**
     * Clears the log file and starts a new session.
     *
     * @throws FileNotFoundException if the log file cannot be created
     */
    public void clearLog() throws FileNotFoundException {
        fout.close();
        fout = new PrintWriter(new File("ShlupkaLog.txt"));
        fout.println("----- New session -----");
    }

    /**
     * Closes the log file and releases resources.
     */
    public void dispose() {
        fout.close();
    }

    /**
     * Inner class representing oars of the boat.
     */
    class Oars {
        private int countOars;

        private Oars() { countOars = 2; }

        private Oars(int countOars) { this.countOars = countOars; }

        private int getCountOars() { return countOars; }

        private void addOars() { countOars++; }

        private void removeOars() {
            if (countOars > 0) countOars--;
            else System.out.println("No oars to remove!");
        }
    }

    /**
     * Inner class representing the hull of the boat.
     */
    class Hull {
        private String material;
        private double lengthMeters;
        private double widthMeters;

        private Hull() {
            material = "wood";
            lengthMeters = 6;
            widthMeters = 2;
        }

        private Hull(String material, double lengthMeters, double widthMeters) {
            this.material = material;
            this.lengthMeters = lengthMeters;
            this.widthMeters = widthMeters;
        }

        private String getMaterial() { return material; }

        private void setMaterial(String material) { this.material = material; }

        private double getLengthMeters() { return lengthMeters; }

        private double getWidthMeters() { return widthMeters; }
    }

    /**
     * Inner class representing seats of the boat.
     */
    class Seats {
        private int countSeats;

        private Seats() { countSeats = 6; }

        private Seats(int countSeats) { this.countSeats = countSeats; }

        private int getCountSeats() { return countSeats; }

        private void addSeats() { countSeats++; }

        private void removeSeats() {
            if (countSeats > 0) countSeats--;
            else System.out.println("No seats to remove!");
        }
    }
}
