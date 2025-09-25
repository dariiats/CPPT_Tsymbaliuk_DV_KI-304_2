package LAB_03;

import java.io.FileNotFoundException;
import LAB_03.interfaces.Flue;
import LAB_03.interfaces.Powered;;

public class motorBoat extends ShlupkaAbs implements Flue, Powered {
    private boolean engineRunning;
    private double fuelLiters;

    public motorBoat() throws FileNotFoundException {

        engineRunning = false;

        fuelLiters = 0;
    }

    public motorBoat(int countOars, String material, double length,
            double width, int countSeats, String nameFile,
            boolean engineRunning, double fuelLiters, double speedMS) throws FileNotFoundException {
        super(countOars, material, length, width, countSeats, nameFile);
        this.fuelLiters = fuelLiters;
        this.engineRunning = engineRunning;
    }

    @Override
    public void moveBoat(double distanceMetres) {
        if (fuelLiters != 0 && distanceMetres <= fuelLiters && engineRunning) {
            fuelLiters -= distanceMetres;

            fout.println("Boat moved " + distanceMetres + ". Remaining fuel: " + fuelLiters);
        }

        else if (!engineRunning) {
            fout.println("Cannot move. Engine turn off!");
        }

        else {
            fout.println("Cannot move. Not enough fuel!");
        }
    }

    @Override
    public void startEngine() {
        engineRunning = true;
        fout.println("Engine turn on!");
    }

    @Override
    public void stopEngine() {
        engineRunning = false;
        fout.println("Engine turn off!");
    }

    @Override
    public void checkFlue() {
        fout.println("Remaining fuel: " + fuelLiters);
    }

    @Override
    public void Refueling(double countFlue) {
        fuelLiters += countFlue;
        fout.println("Boat is refueling!. Remaining fuel: " + fuelLiters);
    }

    @Override
    public void boatInfo() {
        super.boatInfo();
        fout.println("Engine running: " + (engineRunning ? "Yes" : "No"));
        fout.println("Fuel liters: " + fuelLiters);
    }
}
