package activities;

interface BicycleParts{
    public int gears = 0;
    public int currentSpeed = 0;

        }
interface BicycleOperations {
    public void applyBrake(int decrement);

    public void speedUp(int increment);
}

abstract class Bicycle implements BicycleParts,BicycleOperations{
   public int gears;
   public int currentSpeed;
    public Bicycle(int x,int y){
        this.gears = x;
        this.currentSpeed = y;
    }
    public void applyBrake(int decrement) {
        currentSpeed =currentSpeed - decrement;
        System.out.println("CurrentSpeed After Brake Applied is : " + currentSpeed);
    }

    @Override
    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Current Speed after BreakRelease is : " + currentSpeed);
    }
    public String bicycleDesc(){
        System.out.println("No. of Gears : " +gears);
        //System.out.println("CurrentSpeed : " + currentSpeed);

        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);

    }
}

class MountainBike extends Bicycle{
 int seatHeight;
    MountainBike(int gears, int currentSpeed,int sHieght) {
        super(gears,currentSpeed);
        seatHeight = sHieght;
    }
public void setHeight(int newValue){
    seatHeight = newValue;
}
    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }
}
    public class Activity7 {
    public static void main(String[] args){
        MountainBike MB = new MountainBike(3,0,20);
     MB.speedUp(20);
     MB.applyBrake(10);
     MB.bicycleDesc();

    }
    }
