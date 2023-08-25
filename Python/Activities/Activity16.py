class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " " + "is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " " + "has stopped")


car1 = Car("Toyota", "T2023", "M198", "TATAHighSpeed", "White")
car2 = Car("Maruti", "T2023", "M198", "TATAHighSpeed", "White")
car3 = Car("Suzuki", "T2023", "M198", "TATAHighSpeed", "White")

car1.accelerate()
car1.stop()

car2.accelerate()

car3.stop()
