import java.util.Random;
import java.util.Scanner;

public class l5_2_7 {
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

    public static double[][] rotateMatrixBy90Counterclockwise(double[][] matrix){
        if (matrix.length == 0) {
            return matrix;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            int bottom = matrix.length - 1 - i;
            for (int j = i; j < bottom; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][bottom];
                matrix[j][bottom] = matrix[bottom][bottom - (j - i)];
                matrix[bottom][bottom - (j - i)] = matrix[bottom - (j - i)][i];
                matrix[bottom - (j - i)][i] = temp;
            }
        }
        return matrix;
    }

    public static double[][] rotateMatrixBy180Counterclockwise(double[][] matrix){
        if (matrix.length == 0) {
            return matrix;
        }
        double[][] tempMatrix = new double[matrix.length][matrix.length];
        int row = 0, column = -1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            column++;
            for (int j =  matrix.length - 1;  j >= 0; j--) {
                tempMatrix[column][row] = matrix[i][j];
                ++row;
            }
            row = 0;
        }
        return tempMatrix;
    }

    public static double[][] rotateMatrixBy270Counterclockwise(double[][] matrix){
        if (matrix.length == 0) {
            return matrix;
        }
        for (int i = 0; i < matrix.length ; i++){
            for (int j = matrix.length - 1 - i; j >= 0; j--){
                double temp = matrix[i][j];
                matrix[i][j] = matrix [matrix.length - 1 - j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        printMatrix(rotateMatrixBy90Counterclockwise(matrix));
        printMatrix(rotateMatrixBy180Counterclockwise(matrix));
        printMatrix(rotateMatrixBy270Counterclockwise(matrix));
    }
}
