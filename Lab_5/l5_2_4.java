import java.util.Random;
import java.util.Scanner;

public class l5_2_4 {
    public static double[][] generateRandomMatrix(int n){
        double[][] matrix = new double[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n;  j++){
                matrix[i][j] =  2 * n  * random.nextDouble() - n + 1;
            }
        }
        return matrix;
    }

    public static void printMatrix(double [][] matrix){
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(doubles[j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static double findSumBetweenTwoPositive(double[][] matrix){
        double sum = 0;
        boolean positive = false;
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (doubles[j] > 0 && !positive) {
                    positive = true;
                } else if (positive && doubles[j] > 0) {
                    break;
                } else if (positive && doubles[j] < 0) {
                    if(j != matrix.length - 1){
                        sum += doubles[j];
                    }
                }
            }
            positive = false;
        }
        return sum;
    }




    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        System.out.printf("Sum = %f", findSumBetweenTwoPositive(matrix));
    }
}
