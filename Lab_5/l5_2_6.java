import java.util.Random;
import java.util.Scanner;

public class l5_2_6 {
    public static double[][] generateRandomMatrix(int n){
        double[][] matrix = new double[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n;  j++){
                matrix[i][j] =  n  * random.nextDouble() - n + 1;
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

    public static double matrixNorm(double[][] matrix){
        double matrixNorm = 0;
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                matrixNorm += Math.pow(doubles[j], 2);
            }
        }
        return Math.sqrt(matrixNorm);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        System.out.printf("Matrix norm = %f", matrixNorm(matrix));
    }
}
