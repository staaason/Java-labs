import java.util.Random;
import java.util.Scanner;

public class l5_2_5 {
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

    public static double[][] transposeMatrix(double[][] matrix){
        double[][] transpose = new double[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        printMatrix(transposeMatrix(matrix));
    }
}
