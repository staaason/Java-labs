import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class l11_6_3 {
    public static void main(String[] args) throws IOException {
        Scanner textFile = new Scanner(new File("D:\\AVA\\src\\3.txt"));
        FileWriter fw = new FileWriter("D:\\AVA\\src\\5.txt");

        double product = 1;
        int count = 0;
        System.out.println("All numbers in text file :");
        while (textFile.hasNextInt()) {
            int nextInt = textFile.nextInt();
            count += 1;
            System.out.println(count + ". " +nextInt);
            if (count%2 == 0){
                product *= nextInt;
                fw.write(nextInt + " ");
            }

        }
        System.out.println("\n Product of paired elements = " + product);
        fw.close();
    }
}
