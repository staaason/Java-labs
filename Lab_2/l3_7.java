public class l3_7 {
    public static void main(String[] args) {
       double m1 = 66.3f;
       double m2 = 50.f;
       double r = 400.f;
       double F = 6.673 * Math.pow(10, -11) * ((m1 * m2)/Math.pow(r,2));
       System.out.printf("F = %e", F);


    }
}
