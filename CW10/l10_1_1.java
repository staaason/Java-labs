import java.util.Scanner;

public class l10_1_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] words = string.split("\\s+");
        System.out.println("Words in text: " + words.length);
    }
}
