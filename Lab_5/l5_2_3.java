import java.util.*;

public class l5_2_3 {
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

    public static int findMaxNumberInRow(double[][] matrix){
        int maxNumber = 0;
        int current = 1;
        double prevElement = matrix[0][0];
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (doubles[j] > prevElement) {
                    current += 1;
                } else {
                    if (current > maxNumber) {
                        maxNumber = current;
                    }
                    current = 1;
                }
                prevElement = doubles[j];
            }
        }
        return maxNumber;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        printMatrix(matrix);
        System.out.printf("Maximum number of ascending numbers = %d", findMaxNumberInRow(matrix));
    }
}
