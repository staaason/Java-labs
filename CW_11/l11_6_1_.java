import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class l11_6_1 {
    public static void main(String[] args) throws IOException {
        Scanner textFile = new Scanner(new File("D:\\AVA\\src\\3.txt"));
        FileWriter fw = new FileWriter("D:\\AVA\\src\\4.txt");

        int sum = 0, count = 0;
        System.out.println("All numbers in text file :");
        while (textFile.hasNextInt()) {
            int nextInt = textFile.nextInt();
            count += 1;
            System.out.println(count + ". " +nextInt);
            sum += nextInt;
            fw.write(nextInt + " ");
        }
        System.out.println("\nTheir sum = " + sum);
        fw.close();
    }
}
