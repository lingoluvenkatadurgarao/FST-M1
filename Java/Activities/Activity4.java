package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args) {
        int[] Num = {10, 5, 3, 8, 1, 6, 2, 9, 4, 7};
        System.out.println("before sorting");
        for (int b = 0; b < Num.length; b++) {
            System.out.println(Num[b]);
        }
        System.out.println("Print like an array before sort");
        System.out.println(Arrays.toString(Num));

        for (int i = 0; i < Num.length - 1; i++) {
            for (int j = 0; j < Num.length-1; j++) {
                if (Num[j] > Num[j+1]) { //Assending order
                   // if(Num[j] > Num[j+1]) { dessending order
                    int temp;
                    temp = Num[j+1];
                    Num[j+1] = Num[j];
                    Num[j] = temp;
                }
            }
            }
        System.out.println("After sorting");
        for (int after : Num) {
            System.out.println(after);
        }
        System.out.println("Print like an array after sort");
        System.out.println(Arrays.toString(Num));
    }
}