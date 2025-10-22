import boat

class MotorBoat(boat.Boat):
    def __init__(self, countOars=2, material="wood", length=6, width=2,
                 countSeats=2, move=False, fuelLiters=0, engineRunning=False):
        super().__init__(countOars, material, length, width, countSeats, move)
        self.__fuelLiters = fuelLiters
        self.__engineRunning = engineRunning

    def startEngine(self):
        if not self.__engineRunning and self.__fuelLiters > 0:
            self.__engineRunning = True
            print("Engine started.")
        elif self.__engineRunning:
            print("Engine already running.")
        else:
            print("Cannot start engine — no fuel!")

    def stopEngine(self):
        if self.__engineRunning:
            self.__engineRunning = False
            print("Engine stopped.")
        else:
            print("Engine already stopped.")

    def refuel(self, liters):
        self.__fuelLiters += liters
        print(f"Boat refueled. Current fuel: {self.__fuelLiters} liters.")

    def checkFlue(self):
        print(f"Remaining flue: {self.__flueLiters} liters.")

    def boatInfo(self):
        super().boatInfo()
        print(f"Engine running: {self.__engineRunning}")
        print(f"Fuel liters: {self.__fuelLiters}")
        
