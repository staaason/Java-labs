import java.util.Scanner;

public class l2_4 {
    static  double calcF(double C){
        return (double) (9 * C/5) + 32;
    }
    public static void main(String[] args) {
        double x;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть дійсне число градусів целісью");
        x = sc.nextDouble();
        System.out.printf("F = %.1f \n", calcF(x));


    }
}
