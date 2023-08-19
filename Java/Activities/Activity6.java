package activities;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

class Plane {
    private final List<String> Passengers;
    private int maxPassengers;

    private Date LastTimeTakeOff;
    private Date LastTimeLanded;

    public Plane() {
        this.maxPassengers = maxPassengers;
        this.Passengers = new ArrayList<>();
    }

    public void onboard(String Passenger) {
        this.Passengers.add(Passenger);
    }

    public Date takeOff() {
        this.LastTimeTakeOff = new Date();
        return LastTimeTakeOff;
    }

    public void land() {
        this.LastTimeLanded = new Date();
        this.Passengers.clear();

    }

    public Date getLastTimeLanded() {
        return LastTimeLanded;
    }

    public List<String> getPassesngers() {
        return Passengers;
    }
}
    public class Activity6  {
public static void main(String[]args) throws InterruptedException {
        Plane P=new Plane();
     //  P.maxPassengers=10;
        P.onboard("ram");
        P.onboard("Laxman");
        P.onboard("Sita");
        Date PlaneTakeoffTime=P.takeOff();
        System.out.println("PlaneTakeoffTime :"+PlaneTakeoffTime);
        List<String> PeopleList=P.getPassesngers();
        System.out.println("People List : "+PeopleList);
        Thread.sleep(5000);
        P.land();
        Date PlaneLandedTime=P.getLastTimeLanded();
        System.out.println("PlaneLandedTime : "+PlaneLandedTime);
        List<String> PeopleListafterLanded=P.getPassesngers();
        System.out.println("PeopleListafterLanded : "+PeopleListafterLanded);
        }
        }


