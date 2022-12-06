package Lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task1_14 {
    /*
    14.Ввести рядки з файлу, записати в список ArrayList. виконати сортування рядків,
    використовуючи метод sort () з класу Collections.

    */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lst = new ArrayList<>();
        Scanner textFile = new Scanner(new File("D:\\AVA\\src\\Lab12\\1.txt"));
        String line;
        while (textFile.hasNext()) {
            line = textFile.nextLine();
            lst.add(line);
        }
        Collections.sort(lst);
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + lst);
        textFile.close();

    }
}
