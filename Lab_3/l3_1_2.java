import java.util.Scanner;

public class l3_1_2 {
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String[] arr = get.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(getMax(arrInt));
        System.out.println(getMin(arrInt));
    }
}
