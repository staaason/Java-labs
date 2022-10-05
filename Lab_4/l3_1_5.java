import java.util.Arrays;
import java.util.Scanner;

public class l3_1_5 {
    static double calc_distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1) + (z2 - z1)*(z2 - z1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System. in);
        System.out.print("\n--point A--\n");
        System.out.print("enter x: ");
        double x = sc.nextDouble();
        System.out.print("enter y: ");
        double y = sc.nextDouble();
        System.out.print("enter z: ");
        double z = sc.nextDouble();
        System.out.print("\n--massive of points xi, yi, zi--");
        System.out.print("\nenter the number of points: ");
        int n = sc.nextInt();
        System.out.println();
        double[] xi = new double[n];
        double[] yi = new double[n];
        double[] zi = new double[n];
        double maxDistance = 0;
        double minDistance = 1000000000;
        int maxInd = 0;
        int minInd = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("\n--point %d--\n", (i + 1));
            System.out.print("enter x: ");
            xi[i] = sc.nextDouble();
            System.out.print("enter y: ");
            yi[i] = sc.nextDouble();
            System.out.print("enter z: ");
            zi[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            double calcDistance = calc_distance(x, y, z, xi[i], yi[i], zi[i]);
            Double distance = Double.parseDouble(String.valueOf(calcDistance)) ;
            if (distance < minDistance) {
                minDistance = distance;
                minInd = i;
            }
            if (distance > maxDistance) {
                maxDistance = distance;
                maxInd = i;
            }
        }
        System.out.printf("\nClosest point: (%f, %f, %f)\n", xi[minInd], yi[minInd], zi[minInd]);
        System.out.printf("\nFurther point: (%f, %f, %f)", xi[maxInd], yi[maxInd], zi[maxInd]);
    }
}
