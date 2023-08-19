package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer,String> colours = new HashMap<>();
        colours.put(1,"Red");
        colours.put(2,"White");
        colours.put(3,"Green");
        colours.put(4,"Yellow");
        colours.put(5,"Purple");
        System.out.println("Set of Colors are: " + colours);
        colours.remove(4);
      //  colours.remove("Purple");
       System.out.println("Green Exists? :" + colours.containsValue("Green"));
       System.out.println("Size of Map: " + colours.size());
       colours.put(4,"Voilet");
       colours.put(6,"Black");
       System.out.println("Latest Map is: " + colours);
    }
}
