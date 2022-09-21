import java.util.Scanner;

public class l3_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        temp = temp.replaceAll("\\s", "");
        temp = temp.replaceAll("\\*", "");
        System.out.println(Math.pow(Double.parseDouble(temp), 3));

    }
}
