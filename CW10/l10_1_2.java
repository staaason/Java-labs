import java.util.Scanner;

public class l10_1_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        System.out.println(builder.reverse());
    }
}
