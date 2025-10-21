import oar
import seats
import hull

class Boat:
    def __init__(self, countOars=2, material="wood", length=6, width=2, countSeats=2, move=False):
        self.oars = oar.Oars(countOars)
        self.hull = hull.Hull(material, length, width)
        self.seats = seats.Seats(countSeats)
        self.passenger = 0
        self.move = move

    def getCountOars(self):
        print(f"Boat has: {self.oars.getCountOars()}")

    def addOars(self):
        self.oars.addOars()
        print(f"Add oars. Boat has: {self.oars.getCountOars()}")

    def removeOars(self):
        self.oars.removeOars()
        print(f"Remove oars. Boat has: {self.oars.getCountOars()}")

    def getHullMaterial(self):
        print(f"Boat material is: {self.hull.getMaterial()}")

    def loadPassengers(self, count):
        if (count + self.passenger) <= self.seats.getCountSeats():
            self.passenger += count
            print(f"Load passengers. Boat has: {self.passenger} passengers")
        else:
            print(f"Too many passengers. Maximum seats: {self.seats.getCountSeats()}. Current: {self.passenger}")

    def unloadPassengers(self, count):
        if self.passenger >= count:
            self.passenger -= count
            print(f"Unload passengers. Boat has: {self.passenger} passengers")
        elif self.passenger == 0:
            print("Impossible unload passenger. Boat is empty!")
        else:
            print(f"Impossible unload this count. Boat has: {self.passenger} passengers")

    def row(self):
        if not self.move and self.passenger > 0 and self.oars.getCountOars() > 0:
            self.move = True
            print(f"Boat starts moving with {self.passenger} passengers")
        elif self.move:
            print("Boat is already moving!")
        else:
            print("Impossible to move! Boat doesn't have passengers or oars")

    def stop(self):
        if self.move:
            self.move = False
            print(f"Boat stops moving with {self.passenger} passengers")
        else:
            print("Boat already stopped!")

    def status(self):
        print(f"Status: {'moving' if self.move else 'not moving'}")

    def passengerCapacityLeft(self):
        left = self.seats.getCountSeats() - self.passenger
        left = left if left >= 0 else 0
        print(f"Available passenger seats: {left}")

    def boatInfo(self):
        print(f"Number of oars: {self.oars.getCountOars()}")
        print(f"Boat's material: {self.hull.getMaterial()}")
        print(f"Hull length: {self.hull.getLengthMeters()}")
        print(f"Hull width: {self.hull.getWidthMeters()}")
        print(f"Seats: {self.seats.getCountSeats()}")
        print(f"Passengers: {self.passenger}")
        print(f"Status: {'moving' if self.move else 'not moving'}")
