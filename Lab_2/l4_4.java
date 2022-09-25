import java.util.Scanner;

public class l4_4 {
    public static double sq(double a, double b, double c, double p){
        return Math.sqrt(p*(p - a) * (p-b) * (p - c ));
    }
    public static void main(String[] args) {
        double a  = 3;
        double b = 3.5f + 3 * Math.pow(2, -111);
        double c = 3.5f + 3 * Math.pow(2, -111);
        double p = a + b + c;
        System.out.println(p);
        System.out.println(sq(a, b, c, p/2));
    }
}
