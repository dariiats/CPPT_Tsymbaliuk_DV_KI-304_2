package LAB_03;

import java.io.FileNotFoundException;

public class Lab3TsymbaliukKI304 {
     public static void main(String[] args) throws FileNotFoundException {
        motorBoat boat = new motorBoat(); 

        boat.boatInfo();

        boat.startEngine();
        boat.Refueling(10);
        boat.moveBoat(5);
        boat.stopEngine();
        boat.checkFlue();

        boat.loadPassangers(3);
        boat.row();
        boat.stop();

        boat.boatInfo();

        boat.dispose();
    }
}
