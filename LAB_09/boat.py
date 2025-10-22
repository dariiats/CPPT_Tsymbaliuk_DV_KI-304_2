import oar
import seats
import hull

class Boat:
    def __init__(self, countOars=2, material="wood", length=6, width=2, countSeats=2, move=False):
        self._oars = oar.Oars(countOars)
        self._hull = hull.Hull(material, length, width)
        self._seats = seats.Seats(countSeats)
        self._passenger = 0
        self._move = move

    def getCountOars(self):
        print(f"Boat has: {self._oars.getCountOars()}")

    def addOars(self):
        self.oars.addOars()
        print(f"Add oars. Boat has: {self._oars.getCountOars()}")

    def removeOars(self):
        self.oars.removeOars()
        print(f"Remove oars. Boat has: {self._oars.getCountOars()}")

    def getHullMaterial(self):
        print(f"Boat material is: {self._hull.getMaterial()}")

    def loadPassengers(self, count):
        if (count + self._passenger) <= self._seats.getCountSeats():
            self._passenger += count
            print(f"Load passengers. Boat has: {self._passenger} passengers")
        else:
            print(f"Too many passengers. Maximum seats: {self._seats.getCountSeats()}. Current: {self._passenger}")

    def unloadPassengers(self, count):
        if self._passenger >= count:
            self._passenger -= count
            print(f"Unload passengers. Boat has: {self._passenger} passengers")
        elif self._passenger == 0:
            print("Impossible unload passenger. Boat is empty!")
        else:
            print(f"Impossible unload this count. Boat has: {self._passenger} passengers")

    def row(self):
        if not self._move and self._passenger > 0 and self._oars.getCountOars() > 0:
            self._move = True
            print(f"Boat starts moving with {self._passenger} passengers")
        elif self._move:
            print("Boat is already moving!")
        else:
            print("Impossible to move! Boat doesn't have passengers or oars")

    def stop(self):
        if self._move:
            self._move = False
            print(f"Boat stops moving with {self._passenger} passengers")
        else:
            print("Boat already stopped!")

    def status(self):
        print(f"Status: {'moving' if self._move else 'not moving'}")

    def passengerCapacityLeft(self):
        left = self._seats.getCountSeats() - self._passenger
        left = left if left >= 0 else 0
        print(f"Available passenger seats: {left}")

    def boatInfo(self):
        print(f"Number of oars: {self._oars.getCountOars()}")
        print(f"Boat's material: {self._hull.getMaterial()}")
        print(f"Hull length: {self._hull.getLengthMeters()}")
        print(f"Hull width: {self._hull.getWidthMeters()}")
        print(f"Seats: {self._seats.getCountSeats()}")
        print(f"Passengers: {self._passenger}")
        print(f"Status: {'moving' if self._move else 'not moving'}")
