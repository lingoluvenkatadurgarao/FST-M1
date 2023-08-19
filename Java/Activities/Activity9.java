package activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity9 {
    public static void main(String[] args){
        String check ="TCS";
        List<String> companyName = new ArrayList<>();
        companyName.add("IBM");
        companyName.add("TCS");
        companyName.add("DELL");
        companyName.add("GOOGLE");
        companyName.add("FINASTRA");
        companyName.add(3,"Delloite");

        for(String list:companyName){
            System.out.println("Existing List: "+ list);
        }
        System.out.println("Existing List in an ArrayForm: "+ companyName);
        companyName.get(2);
        System.out.println("Check Company Exists in the List : " + companyName.contains(check));
        System.out.println("Size of a List : " + companyName.size());
        companyName.remove(2);
        for(String S:companyName){
            System.out.println("New List: "+ S);
        }
        System.out.println("New List Size : " +companyName.size() );


    }


}
