package LAB_02;

import java.io.FileNotFoundException;

public class Lab2TsumbaliukKI304 {
    public static void main(String[] args) throws FileNotFoundException {
        Shlupka boat1 = new Shlupka();

        boat1.boatInfo();

        boat1.loadPassangers(1);

        boat1.unloadPassangers(2);

        boat1.boardAllPassengers();

        boat1.passengerCapacityLeft();

        boat1.status();

        boat1.row();

        boat1.stop();

        boat1.boatInfo();

        boat1.dispose();

        Shlupka boat2 = new Shlupka(4, "plastic", 8, 4, 8, "ShlupkaLog2.txt");

        boat2.boatInfo();

        boat2.loadPassangers(5);

        boat2.unloadPassangers(2);

        boat2.boardAllPassengers();

        boat2.passengerCapacityLeft();

        boat2.status();

        boat2.row();

        boat2.stop();

        boat2.boatInfo();

        boat2.dispose();
    }
}
