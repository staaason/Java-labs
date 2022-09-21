import java.util.Scanner;

public class l3_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        System.out.println(Integer.toHexString(Integer.parseInt(temp, 16)- 1));
        System.out.println(Integer.parseInt(temp, 16) - 1);
    }
}
