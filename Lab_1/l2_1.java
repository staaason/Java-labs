import java.util.Scanner;

public class l2_1 {
    public static void main(String[] args) {
        System.out.println("Введіть прізвище");
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();

        System.out.printf("Привіт, %s",temp);
    }
}
