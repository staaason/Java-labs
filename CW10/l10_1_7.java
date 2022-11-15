import java.util.Scanner;

public class l10_1_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] strings = string.split("([\\W\\s]+)");
        int split = string.split("([.!,:?])",-1).length-1;
        int sentences = string.split("([.!?])",-1).length-1;
        System.out.println("Characters in text:" + string.length());
        System.out.println("Words in text:" + strings.length);
        System.out.println("Punctuation in text:" + split);
        System.out.println("Sentences in text:" + sentences);

    }
}
