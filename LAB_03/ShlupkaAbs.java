package LAB_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Abstract class ShlupkaAbs models a rowing boat with oars, hull, and seats.
 * It allows managing passengers, boat movement, and logs all actions to a file.
 */
public abstract class ShlupkaAbs {

    /** Represents the boat's oars. */
    protected Oars oars;

    /** Represents the boat's hull. */
    protected Hull hull;

    /** Represents the boat's seats. */
    protected Seats seats;

    /** Current number of passengers in the boat. */
    protected int passanger;

    /** Indicates whether the boat is moving. */
    protected boolean move;

    /** Output writer for logging actions to a file. */
    protected PrintWriter fout;

    /**
     * Default constructor. Creates a boat with default configuration:
     * 2 oars, wooden hull 6x2 meters, 6 seats, log file "Log.txt".
     *
     * @throws FileNotFoundException if the log file cannot be created
     */
    public ShlupkaAbs() throws FileNotFoundException {
        this.oars = new Oars();
        this.hull = new Hull();
        this.seats = new Seats();
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructor with parameters to create a boat with specific configuration.
     *
     * @param countOars number of oars
     * @param material hull material
     * @param length hull length in meters
     * @param width hull width in meters
     * @param countSeats number of seats
     * @param nameFile name of the log file
     * @throws FileNotFoundException if the log file cannot be created
     */
    public ShlupkaAbs(int countOars, String material, double length, double width, int countSeats, String nameFile)
            throws FileNotFoundException {
        oars = new Oars(countOars);
        hull = new Hull(material, length, width);
        seats = new Seats(countSeats);
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File(nameFile));
    }

    /**
     * Abstract method to move the boat a certain distance.
     *
     * @param distanceMetres distance to move in meters
     */
    public abstract void moveBoat(double distanceMetres);

    /**
     * Logs the number of oars the boat currently has.
     */
    public void getCountOars() {
        fout.println("Boat has: " + oars.getCountOars());
    }

    /**
     * Adds one oar to the boat and logs the action.
     */
    public void addOars() {
        oars.addOars();
        fout.println("Add oars. Boat has: " + oars.getCountOars());
    }

    /**
     * Removes one oar from the boat and logs the action.
     */
    public void removeOars() {
        oars.removeOars();
        fout.println("Remove oars. Boat has: " + oars.getCountOars());
    }

    /**
     * Logs the material of the boat's hull.
     */
    public void getHullMaterial() {
        fout.println("Boat material is: " + hull.getMaterial());
    }

    /**
     * Loads a specified number of passengers onto the boat.
     *
     * @param count number of passengers to load
     */
    public void loadPassangers(int count) {
        if ((count + passanger) <= seats.countSeats) {
            passanger += count;
            fout.println("Load passengers. Boat has: " + passanger + " passengers");
        } else {
            fout.println("Too many passengers. Maximum seats: " + seats.countSeats + ". Current: " + passanger);
        }
    }

    /**
     * Unloads a specified number of passengers from the boat.
     *
     * @param count number of passengers to unload
     */
    public void unloadPassangers(int count) {
        if (passanger >= count) {
            passanger -= count;
            fout.println("Unload passengers. Boat has: " + passanger + " passengers");
        } else if (passanger == 0) {
            fout.println("Impossible unload passengers. Boat is empty!");
        } else {
            fout.println("Impossible unload this count. Boat has: " + passanger + " passengers");
        }
    }

    /**
     * Starts moving the boat if there are passengers and oars.
     */
    public void row() {
        if (!move && passanger > 0 && oars.getCountOars() > 0) {
            move = true;
            fout.println("Boat starts moving with " + passanger + " passengers");
        } else if (move) {
            fout.println("Boat is already moving!");
        } else {
            fout.println("Impossible to move! Boat doesn't have passengers or oars");
        }
    }

    /**
     * Stops the boat if it is moving.
     */
    public void stop() {
        if (move) {
            move = false;
            fout.println("Boat stops moving with " + passanger + " passengers");
        } else {
            fout.println("Boat already stopped!");
        }
    }

    /**
     * Logs the current movement status of the boat.
     */
    public void status() {
        fout.println("Status: " + (move ? "moving" : "not moving"));
    }

    /**
     * Logs the number of free seats available for passengers.
     */
    public void passengerCapacityLeft() {
        int left = seats.getCountSeats() - passanger;
        left = left >= 0 ? left : 0;
        fout.println("Available passenger seats: " + left);
    }

    /**
     * Logs full information about the boat's configuration and current state.
     */
    public void boatInfo() {
        fout.println("Number of oars: " + oars.getCountOars());
        fout.println("Boat material: " + hull.getMaterial());
        fout.println("Hull length: " + hull.getLengthMeters());
        fout.println("Hull width: " + hull.getWidthMeters());
        fout.println("Seats: " + seats.getCountSeats());
        fout.println("Passengers: " + passanger);
        fout.println("Status: " + (move ? "moving" : "not moving"));
    }

    /**
     * Closes the log file and releases resources.
     */
    public void dispose() {
        fout.close();
    }

    /**
     * Inner class representing the oars of the boat.
     */
    class Oars {
        private int countOars;

        private Oars() {
            countOars = 2;
        }

        private Oars(int countOars) {
            this.countOars = countOars;
        }

        private int getCountOars() {
            return countOars;
        }

        private void addOars() {
            countOars++;
        }

        private void removeOars() {
            if (countOars > 0)
                countOars--;
            else
                System.out.println("No oars to remove!");
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

        private String getMaterial() {
            return material;
        }

        private double getLengthMeters() {
            return lengthMeters;
        }

        private double getWidthMeters() {
            return widthMeters;
        }
    }

    /**
     * Inner class representing the seats of the boat.
     */
    class Seats {
        private int countSeats;

        private Seats() {
            countSeats = 6;
        }

        private Seats(int countSeats) {
            this.countSeats = countSeats;
        }

        private int getCountSeats() {
            return countSeats;
        }
    }
}
