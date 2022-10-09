import java.util.Scanner;

public class l3_1_3 {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String[] arr = get.nextLine().split(" ");
        double[] arrDouble = new double[arr.length];
        double total = 0;
        for(int i = 0; i < arr.length; ++i){
            arrDouble[i] = Double.parseDouble(arr[i]);
            total = total + arrDouble[i];
        }

        double mean = total / arrDouble.length;
        double standardDeviation = 0;
        for(double num: arrDouble) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        System.out.println(mean);
        System.out.println(Math.sqrt(standardDeviation/arrDouble.length));
    }
}
