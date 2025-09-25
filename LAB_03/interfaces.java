package LAB_03;

public class interfaces {

    public interface Powered {
        void startEngine();

        void stopEngine();
    }

    public interface Flue {
        void checkFlue();

        void Refueling(double countFlue);
    }
}
