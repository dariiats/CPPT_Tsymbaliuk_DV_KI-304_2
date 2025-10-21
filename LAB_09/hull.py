class Hull:
    def __init__(self, material = "wood", lengthMeters = 6, widthMeters = 2):
        self.material = material
        self.lenghtMeters = lengthMeters
        self.widthMeters = widthMeters
    
    def getMaterial(self):
        return self.material
    
    def getLengthMeters(self):
        return self.lenghtMeters
    
    def getWidthMeters(self):
        return self.widthMeters
    