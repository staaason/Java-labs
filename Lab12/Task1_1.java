package Lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1_1 {
    /*
        1.Ввести рядки з файлу, записати в список. Вивести рядки в файл в зворотному порядку.
    */

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lst = new ArrayList<>();
        Scanner textFile = new Scanner(new File("D:\\AVA\\src\\Lab12\\1.txt"));
        String line;
        while (textFile.hasNext()) {
            line = textFile.nextLine();
            lst.add(line);
        }
        File file = new File("D:\\AVA\\src\\Lab12\\output1.txt");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        for(int i = lst.size() - 1; i >=0; i--) {
            System.out.println(lst.get(i)+" ");
        }
        textFile.close();


    }
}
