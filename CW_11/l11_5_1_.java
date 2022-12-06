import java.io.*;
import java.util.Scanner;

public class l11_5_1 {

    public static void  handleFile() throws IOException {
        int count = 0;
        String longest_word = "";
        String current;

        Scanner sc = new Scanner(new File("D:\\AVA\\src\\1.txt"));
        while (sc.hasNext()) {
            current = sc.next();
            count += 1;
            if (current.length() > longest_word.length()) {
                longest_word = current;
            }
        }
        PrintStream out = new PrintStream(new FileOutputStream("D:/AVA/src/2.txt"));
        System.setOut(out);


        //part a
        System.out.println("\nLongest word: " + longest_word);

        //part b
        System.out.println("\nNumber of words in file: " + count + "\n");
        FileReader fr = new FileReader("D:/AVA/src/1.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        //part c
        while((line = br.readLine()) != null) {
            line = line.replaceAll("\\b[\\w']{1}\\b", "").replaceAll("\\s+", " ").trim();
            line=line.replaceAll("\\s+", " ");
            System.out.println(line);

        }

        //part d
        while((line = br.readLine()) != null) {
            line = line.replaceAll("\\s+", " ").trim();
            line=line.replaceAll("\\s+", " ");
            System.out.println(line);
        }



    }

    public static void main(String[] args) throws IOException {
        handleFile();

    }
}
