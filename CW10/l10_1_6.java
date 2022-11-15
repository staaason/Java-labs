import java.util.Scanner;

public class l10_1_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        StringBuffer buffer = new StringBuffer(string);
        buffer.append(",that we use to illustrate the methods of class StringBuffer");
        System.out.println(buffer.toString());
    }
}
