import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class l11_6_2_sam {
    public static void main(String[] args) throws IOException {
        Scanner textFile = new Scanner(new File("D:\\AVA\\src\\7.txt"));

        int count = 0;
        int countSquare = 0;
        double square;
        System.out.println("Count even numbers in text file :");
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int length = 1;
        int max = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (textFile.hasNextInt()) {
            int nextInt = textFile.nextInt();
            if(nextInt % 2 == 0){
                count += 1;
            }
            square = Math.sqrt(nextInt)  % 2;
            if(square != 0 && square == (int)square){
                countSquare += 1;
            }
            if (nextInt > largest && nextInt % 2 == 0) {
                largest = nextInt;
            }

            if (nextInt <  smallest && nextInt % 2 != 0) {
                smallest = nextInt;
            }
            arrayList.add(nextInt);
        }
        int old = arrayList.get(0);
        for(int i = 1; i < arrayList.size();i++){
            if(arrayList.get(i)  > old){
                ++length;
            }else{
                if(length > max){
                    max = length;
                }
                length = 1;
            }
            old = arrayList.get(i);
        }


        System.out.print(count);
        System.out.println();
        System.out.println("Count square not even numbers in text file : " + countSquare);
        System.out.println("Diff between largest even and smallest not even in text file : "  + (largest + smallest));
        System.out.println("Number of numbers of the largest sequence  in text file : "  + max);
    }

}
