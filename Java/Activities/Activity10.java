package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        HashSet hs = new HashSet<>();
        hs.add(1);
        hs.add('a');
        hs.add("Apple");
        hs.add("Red");
        hs.add("Tomoto");
        hs.add("Tomoto");
        hs.add("@#$%&*");
        System.out.println("Size of Hashset is: " + hs.size());
        System.out.println("Created Set: " + hs);
        hs.remove("Tomoto");
        hs.remove("Mango");
        System.out.println("Is Empty set: " + hs.isEmpty());
        System.out.println("Is Item Present: " + hs.contains("Apple"));
        System.out.println("Updated Set: " + hs);
    }
}
