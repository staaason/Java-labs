import java.util.Scanner;

public class l2_4_4 {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int counter = 0;
        for(int i = 10; i < 100; ++i){
            if(counter == n){
                counter = 0;
                System.out.println();
            }
            System.out.printf("%d ", i);
            counter++;
        }
    }
}
