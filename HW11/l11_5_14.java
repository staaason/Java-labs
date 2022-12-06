import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l11_5_14 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\AVA\\src\\6.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        System.out.println("Введіть прізвище та ініціали співробітника");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip();
        Pattern pattern = Pattern.compile(input);
        while((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String[] arg =  line.split("\\s+");
                System.out.println("Номер співробітника: " + arg[2]);
            }
        }
    }
}
