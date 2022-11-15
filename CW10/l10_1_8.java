import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l10_1_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String word = sc.nextLine();
        String group = "";
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            group = matcher.group();
        }
        if(group.equalsIgnoreCase(word)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        //with case_sensitive
        Pattern pattern2 = Pattern.compile(word);
        Matcher matcher2 = pattern2.matcher(string);
        while (matcher2.find()) {
            group = matcher2.group();
        }
        if(group.equals(word)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
