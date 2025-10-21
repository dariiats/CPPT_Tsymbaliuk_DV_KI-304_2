import boat

class MotorBoat(boat.Boat):
    def __init__(self, countOars=2, material="wood", length=6, width=2,
                 countSeats=2, move=False, fuelLiters=0, engineRunning=False):
        super().__init__(countOars, material, length, width, countSeats, move)
        self.fuelLiters = fuelLiters
        self.engineRunning = engineRunning

    def startEngine(self):
        if not self.engineRunning and self.fuelLiters > 0:
            self.engineRunning = True
            print("Engine started.")
        elif self.engineRunning:
            print("Engine already running.")
        else:
            print("Cannot start engine — no fuel!")

    def stopEngine(self):
        if self.engineRunning:
            self.engineRunning = False
            print("Engine stopped.")
        else:
            print("Engine already stopped.")

    def refuel(self, liters):
        self.fuelLiters += liters
        print(f"Boat refueled. Current fuel: {self.fuelLiters} liters.")

    def checkFlue(self):
        print(f"Remaining flue: {self.flueLiters} liters.")

    def boatInfo(self):
        super().boatInfo()
        print(f"Engine running: {self.engineRunning}")
        print(f"Fuel liters: {self.fuelLiters}")
        
