package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.*;

public class Activity13 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();
        System.out.println("Enter only Integer Numbers else the Reading from Input is terminated:");
        while(scan.hasNextInt()) {

                list.add(scan.nextInt());
        }
        System.out.println(list);
        Integer num[] =list.toArray(new Integer[0]);
        int index = indexGen.nextInt(num.length);
        System.out.println("Random Value Generated is :" + index + "\n" + "Value w.r.to RandomNumber indexed ArrayValue is :" + num[index]);
        scan.close();
    }
}

