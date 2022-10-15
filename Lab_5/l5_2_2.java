import java.util.*;

public class l5_2_2 {
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

    public static void shiftLeft(double[][] matrix, int position){
        for(int i = 0; i < matrix.length; i++){
           int currentPosition = position;
           while(currentPosition-- > 0){
               double temp = matrix[i][0];
               for(int j = matrix.length - 1 ; j >= 0 ; j--){
                   double value = matrix[i][j];
                   matrix[i][j] = temp;
                   temp = value;
               }
           }
        }
    }

    public static void shiftRight(double[][] matrix, int position){
        double[][] copy = new double[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix.length; ++j){
                int newPosition = (j + position) % matrix.length;
                copy[i][newPosition] = matrix[i][j];
            }
        }
        printMatrix(copy);
    }

    public static void main(String[] args) {
        int n;
        int k = 2;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        shiftRight(matrix, k);
        shiftLeft(matrix, k);
        printMatrix(matrix);

    }
}
