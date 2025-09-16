package LAB_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Shlupka {

    private Oars oars;
    private Hull hull;
    private Seats seats;
    private int passanger;
    private boolean move;
    PrintWriter fout;

    public Shlupka() throws FileNotFoundException {
        this.oars = new Oars();
        this.hull = new Hull();
        this.seats = new Seats();
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File("ShlupkaLog.txt"));
    }

    public Shlupka(int countOars, String material, double length, double width, int countSeats, String nameFile)
            throws FileNotFoundException {
        oars = new Oars(countOars);
        hull = new Hull(material, length, width);
        seats = new Seats(countSeats);
        passanger = 0;
        move = false;
        fout = new PrintWriter(new File(nameFile));
    }

    public void loadPassangers(int count) {
        if ((count + passanger) <= seats.countSeats) {
            passanger = passanger + count;
            fout.println("Load passangers. Boat has: " + passanger + " passangers");
        }

        else {
            fout.println("Too much passangers. Maximum passangers on boat is : " + seats.countSeats + ". Boat has: "
                    + passanger + " passangers");
        }
    }

    public void boardAllPassengers() {
        int availableSeats = seats.getCountSeats() - passanger;
        
        if (availableSeats > 0) {
            passanger = passanger + availableSeats;
            fout.println("All available passengers boarded: " + availableSeats + " passengers. Total now: " + passanger);
        } 
        
        else {
            fout.println("No available seats to board passengers. Total passengers: " + passanger);
        }
    }

    public void unloadPassangers(int count) {
        if (passanger > 0 && passanger >= count) {
            passanger = passanger - count;
            fout.println("Unload passangers. Boat has: " + passanger + " passangers");
        }

        else if (passanger == 0) {
            fout.println("Impossible unload passanger. Boats is empty!");
        }

        else {
            fout.println("Impossible unload this passangers' count. Boat has: " + passanger + " passangers");
        }
    }

    public void row() {
        if (!move && passanger > 0 && oars.getCountOars() > 0) {
            move = true;
            fout.println("Boat start to move with " + passanger + " passangers");
        }

        else if (move) {
            fout.println("Boat is aleady moving!");
        }

        else {
            fout.println("Impossible to move! Boat doesn't have passangers or oars");
        }
    }

    public void stop() {
        if (move && passanger > 0 && oars.getCountOars() > 0) {
            move = false;
            fout.println("Boat stop to move with " + passanger + " passangers");
        }

        else if (!move) {
            fout.println("Boat already stop!");
        }

        else {
            fout.println("Impossible to stop! Boat doesn't have passangers or oars");
        }
    }

    public void status() {
        fout.println("Status: " + (move == false ? "doesn't moving" : "moving"));
    }

    public void passengerCapacityLeft() {
        int left = (seats.getCountSeats() - passanger) >= 0 ? (seats.getCountSeats() - passanger) : 0;
        fout.println("Available passenger seats: " + left);
    }

    public void boatInfo() {
        fout.println("Number of oars: " + oars.getCountOars());
        fout.println("Boat's material: " + hull.material);
        fout.println("Boat's lenght: " + hull.lengthMeters);
        fout.println("Boat's width: " + hull.widthMeters);
        fout.println("Seats: " + seats.countSeats);
        fout.println("Passangers: " + passanger);
        fout.println("Status: " + (move == false ? "doesn't moving" : "moving"));
    }

    public void clearLog() throws FileNotFoundException {
        fout.close();
        fout = new PrintWriter(new File("ShlupkaLog.txt"));
        fout.println("----- New session -----");
    }

    public void dispose() {
        fout.close();
    }

    class Oars {
        private int countOars;

        private Oars(int countOars) {
            this.countOars = countOars;
        }

        private Oars() {
            countOars = 2;
        }

        private int getCountOars() {
            return countOars;
        }

        private void setCountOars(int countOars) {
            this.countOars = countOars;
        }

        private void addOars() {
            countOars++;
        }

        private void removeOars() {
            if (countOars > 0)
                countOars--;
            else
                System.out.println("You already haven't oars!");
        }
    }

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

        private void setMaterial(String material) {
            this.material = material;
        }

        private void setLengthMeters(double lengthMeters) {
            this.lengthMeters = lengthMeters;
        }

        private void setWidthMeters(double widthMeters) {
            this.widthMeters = widthMeters;
        }
    }

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

        private void setCountSeats(int countSeats) {
            this.countSeats = countSeats;
        }

        private void addSeats() {
            countSeats++;
        }

        private void removeSeats() {
            if (countSeats > 0)
                countSeats--;
            else
                System.out.println("You already haven't seats!");
        }
    }
}
