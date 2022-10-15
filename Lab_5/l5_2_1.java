import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class l5_2_1 {

    public static double[][] generateRandomMatrix(int n){
        double[][] matrix = new double[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n;  j++){
                matrix[i][j] =  n  * random.nextDouble() - n + 1;;
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

    public static void sortMatrixByColumn(double[][] matrix, int k){
        Map<Integer, Double> valuesMap = new java.util.HashMap<>(Collections.emptyMap());
        double[] tempArr  = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            tempArr[i] = matrix[i][k];
        }
        Arrays.sort(tempArr);
        for(int i = 0; i < matrix.length; i++){
            valuesMap.put(i, tempArr[i]);
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[i][k] = valuesMap.get(i);
        }
    }

    public static void sortMatrixByRow(double[][] matrix, int k){
        Map<Integer, Double> valuesMap = new java.util.HashMap<>(Collections.emptyMap());
        double[] tempArr  = new double[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            tempArr[i] = matrix[k][i];
        }
        Arrays.sort(tempArr);
        for(int i = 0; i < matrix.length; i++){
            valuesMap.put(i, tempArr[i]);
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[k][i] = valuesMap.get(i);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[][] matrix = generateRandomMatrix(n);
        int k = 1;
        sortMatrixByColumn(matrix, k);
        printMatrix(matrix);
        sortMatrixByRow(matrix, k);
        printMatrix(matrix);

    }
}
