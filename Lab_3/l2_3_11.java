import java.util.Scanner;

public class l2_3_11 {
    public static void main(String[] args){
        double xl1, yl1, xr1, yr1;
        double xl2, yl2, xr2, yr2;
        double xl3, yl3, xr3, yr3;
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        double[] arrInt = new double[arr.length];
        for(int i = 0; i < arr.length; ++i){
            arrInt[i] = Double.parseDouble(arr[i]);
        }
        xl1 = arrInt[0];
        yl1 = arrInt[1];
        xr1 = arrInt[2];
        yr1 = arrInt[3];
        xl2 = arrInt[4];
        yl2 = arrInt[5];
        xr2 = arrInt[6];
        yr2 = arrInt[7];
        if(xl1 == xl2 || yr2 == yr1 || xr2 == xr1 || yl1 == yl2){
            System.out.println("Не перетинаються");
        }else if(xl1 > xl2 || xr2 > xr1){
            System.out.println("Не перетинаються");
        }else if(yr1 > yr2 || yl2 > yl1){
            System.out.println("Не перетинаються");
        }else{
            System.out.println("Перетинаються");
            xl3 = Math.max(xl1, xl2);
            yl3 = Math.max(yl1, yl2);
            xr3 = Math.min(xr1, xr2);
            yr3 = Math.min(yr1, yr2);
            System.out.printf("Лівий нижній кут: %.1f %.1f\n", xl3, yl3);
            System.out.printf("Правий  верхній кут: %.1f %.1f", xr3, yr3);
        }
    }
}
