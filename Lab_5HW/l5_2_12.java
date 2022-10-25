import java.util.Random;
import java.util.Scanner;

public class l5_2_12 {
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

    public static void findMinMatrix(double[][] matrix, int row, int column){
        double min = matrix[0][0];
        int pi = 0, pj = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                    pi = i;
                    pj = j;
                }
            }
        }
        System.out.println("min: " + min + ", i = " + ++pi + ", j = " + ++pj);
        --pi;
        --pj;
        double tmp;
        for (int i = 0; i < matrix.length; i++) {
            tmp = matrix[pi][i];
            matrix[pi][i] = matrix[row][i];
            matrix[row][i] = tmp;
        }
        for (int i = 0; i < matrix.length; i++) {
            tmp = matrix[i][pj];
            matrix[i][pj] = matrix[i][column];
            matrix[i][column] = tmp;
        }
    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        int row = 0, column = 0;
        System.out.println("Enter row and column: ");
        row =  sc.nextInt();
        column = sc.nextInt();
        printMatrix(matrix);
        findMinMatrix(matrix, --row, --column);
        printMatrix(matrix);

    }
}
