package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] numbers = {10, 77, 10, 10, -11, 10};
        int sum = 0;
        int i;
        for (i = 0; i < 6; i++) {
            if (numbers[i] == 10) {
                sum = sum + numbers[i];

                if (sum >30){
                    break;
                }
            }
        }
        if (sum == 30) {
            System.out.println("True");
        } else {
            System.out.println("false");
        }
    }
}
