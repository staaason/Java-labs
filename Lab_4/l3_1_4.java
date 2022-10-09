import java.util.*;

public class l3_1_4 {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String[] arr = get.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int prev = arrInt[0];
        int maxCounter = 0;
        int maxNum = 0;
        int curCounter = 0;
        for(int i: arrInt){
            if (prev == i)
                curCounter++;

            else {
                if (curCounter > maxCounter) {
                    maxCounter = curCounter;
                    curCounter = 0;
                    maxNum = prev;
                }
                prev = i;
            }
        }

        System.out.printf("%d підряд чисел  %d", ++maxCounter, maxNum);
    }
}
