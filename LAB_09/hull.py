class Hull:
    def __init__(self, material = "wood", lengthMeters = 6, widthMeters = 2):
        self._material = material
        self._lenghtMeters = lengthMeters
        self._widthMeters = widthMeters
    
    def getMaterial(self):
        return self._material
    
    def getLengthMeters(self):
        return self._lenghtMeters
    
    def getWidthMeters(self):
        return self._widthMeters
    