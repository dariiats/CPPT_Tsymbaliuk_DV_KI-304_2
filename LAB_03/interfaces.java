package LAB_03;

/**
 * This class contains interfaces for motorized boats.
 */
public class interfaces {

    /**
     * Powered interface represents engine operations.
     * Classes implementing this interface can start and stop the engine.
     */
    public interface Powered {

        /**
         * Starts the engine.
         */
        void startEngine();

        /**
         * Stops the engine.
         */
        void stopEngine();
    }

    /**
     * Flue interface represents fuel management.
     * Classes implementing this interface can check fuel level and refuel.
     */
    public interface Flue {

        /**
         * Checks the current fuel level and logs or displays it.
         */
        void checkFlue();

        /**
         * Refuels the vehicle with a specified amount of fuel.
         * 
         * @param countFlue amount of fuel to add in liters
         */
        void Refueling(double countFlue);
    }
}
