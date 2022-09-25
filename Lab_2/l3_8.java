import java.util.Scanner;


public class l3_8 {



    public static void main(String[] args) {
        double x;
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        System.out.println((int)Math.floor(x));
        if(x > 0){
            System.out.println(x - Math.floor(x));
            System.out.println(x - Math.floor(x));
        }else{
            System.out.println((x - Math.floor(x)) - 1);
            System.out.println((x - Math.floor(x)) - 1);
        }
        System.out.println((int)Math.floor(x));
        System.out.printf("%d <  %f < %d", (int)Math.floor(x), x, (int)Math.ceil(x));






    }
}
