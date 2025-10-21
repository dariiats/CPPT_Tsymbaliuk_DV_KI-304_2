from boat import Boat
from motorBoat import MotorBoat

def main():
    print("=== Regular Boat Demo ===")
    boat = Boat(countOars=2, countSeats=4)
    boat.loadPassengers(3)
    boat.row()
    boat.stop()
    boat.boatInfo()

    print("\n=== Motor Boat Demo ===")
    mboat = MotorBoat(fuelLiters=15, countSeats=4)
    mboat.startEngine()
    mboat.loadPassengers(2)
    mboat.refuel(5)
    mboat.stopEngine()
    mboat.boatInfo()

if __name__ == "__main__":
    main()
