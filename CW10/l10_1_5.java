import java.util.Scanner;

public class l10_1_5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        string  = string.replaceAll("\\bsmall\\b\\s*", "very small ");
        string  = string.replaceAll("\\blarge\\b\\s*", "very large ");
        string = string.trim();
        System.out.println(string);
    }

}
