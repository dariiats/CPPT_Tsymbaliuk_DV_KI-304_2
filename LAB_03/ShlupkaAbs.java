package LAB_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class <code>Shlupka</code> models a rowing boat with oars, hull, and seats.
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
     * <ul>
     *     <li>2 oars</li>
     *     <li>wooden hull 6x2 meters</li>
     *     <li>6 seats</li>
     *     <li>log file: "ShlupkaLog.txt"</li>
     * </ul>
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
     * @param countOars  number of oars
     * @param material   material of the hull
     * @param length     hull length in meters
     * @param width      hull width in meters
     * @param countSeats number of seats
     * @param nameFile   name of the log file
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
        fout.println("Boat materials is: " + hull.getMaterial());
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
        fout.println("Boat's material: " + hull.getMaterial());
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
     * Inner class representing oars of the boat.
     */
    class Oars {
        /** Number of oars. */
        private int countOars;

        /**
         * Default constructor. Creates 2 oars.
         */
        private Oars() {
            countOars = 2;
        }

        /**
         * Constructor with parameter.
         *
         * @param countOars number of oars
         */
        private Oars(int countOars) {
            this.countOars = countOars;
        }

        /**
         * Gets the number of oars.
         *
         * @return number of oars
         */
        private int getCountOars() {
            return countOars;
        }

        /**
         * Adds one oar.
         */
        private void addOars() {
            countOars++;
        }

        /**
         * Removes one oar if available, otherwise prints a warning.
         */
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
        /** Material of the hull. */
        private String material;

        /** Length of the hull in meters. */
        private double lengthMeters;

        /** Width of the hull in meters. */
        private double widthMeters;

        /**
         * Default constructor. Creates a wooden hull 6x2 meters.
         */
        private Hull() {
            material = "wood";
            lengthMeters = 6;
            widthMeters = 2;
        }

        /**
         * Constructor with parameters.
         *
         * @param material     hull material
         * @param lengthMeters hull length
         * @param widthMeters  hull width
         */
        private Hull(String material, double lengthMeters, double widthMeters) {
            this.material = material;
            this.lengthMeters = lengthMeters;
            this.widthMeters = widthMeters;
        }

        /**
         * Gets the hull material.
         *
         * @return hull material
         */
        private String getMaterial() {
            return material;
        }

        /**
         * Gets the hull length in meters.
         *
         * @return hull length
         */
        private double getLengthMeters() {
            return lengthMeters;
        }

        /**
         * Gets the hull width in meters.
         *
         * @return hull width
         */
        private double getWidthMeters() {
            return widthMeters;
        }
    }

    /**
     * Inner class representing seats of the boat.
     */
    class Seats {
        /** Number of seats in the boat. */
        private int countSeats;

        /**
         * Default constructor. Creates 6 seats.
         */
        private Seats() {
            countSeats = 6;
        }

        /**
         * Constructor with parameter.
         *
         * @param countSeats number of seats
         */
        private Seats(int countSeats) {
            this.countSeats = countSeats;
        }

        /**
         * Gets the number of seats.
         *
         * @return number of seats
         */
        private int getCountSeats() {
            return countSeats;
        }
    }
}
