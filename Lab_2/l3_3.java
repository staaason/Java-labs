import java.util.Scanner;

public class l3_3 {
    public static void main(String[] args) {
        System.out.print("Введіть ім'я:" );
        String name;
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Привіт, " + name + "!");
    }
}
