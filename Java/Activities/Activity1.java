package activities;

public class Activity1 {
    public static void main(String[] args){
        Car MyCar = new Car();
        MyCar.make=2014;
        MyCar.color="Black";
        MyCar.transmission="Manual";
        MyCar.displayCharacteristics();
        MyCar.accelarate();
        MyCar.brake();

    }
}
