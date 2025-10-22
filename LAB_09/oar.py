class Oars:
    def __init__(self, countOars=2):
        self._countOars = countOars

    def getCountOars(self):
        return self._countOars
    
    def addOars(self):
        self._addOars+=1
    
    def removeOars(self):
        self._removeOars+=1
