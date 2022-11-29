import java.io.*;

public class l11_5_2 {
    public static void main(String[] args) throws  IOException {
        int empty = 0;

        FileReader fr = new FileReader("D:\\AVA\\src\\1.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        //part a
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                empty++;
            }
        }
        System.out.println("Number of empty lines: " + empty);

        // part b

//        String max_line = "";
//        int max_length = 0;
//        while ((line = br.readLine()) != null) {
//            if (line.length() > max_length) {
//                max_length = line.length();
//                max_line = line;
//            }
//        }
//        System.out.println("Longest line is: \n" + max_line + "\n its length: " + max_length);


        fr.close();
    }
}
