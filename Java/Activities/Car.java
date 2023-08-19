package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    Car(){
           tyres=4;
           doors=4;
        }
    public void displayCharacteristics(){
        System.out.println("No of tryes on the car is:" + tyres);
        System.out.println("No of doors in a Car is:" + doors);
        System.out.println("Making of car is:" + make);
        System.out.println("Color of the Car is:" + color);
        System.out.println("Transmission type of the car is:" + transmission);

    }
    public void accelarate(){
     System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");

    }

}
