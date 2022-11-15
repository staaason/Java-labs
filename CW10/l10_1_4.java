import java.util.Scanner;

public class l10_1_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        string  = string.replaceAll("\\ba\\b\\s*|\\ban\\b\\s*", "");
        string = string.trim();
        System.out.println(string);
    }
}
