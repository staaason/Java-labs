import java.util.Scanner;

public class l3_1_14 {
    public static void deleteDuplicates(int[] arrInt){
        if(arrInt.length == 0){
            System.out.println();
        }else if(arrInt.length == 1){
            System.out.println(arrInt[0]);
        } else{
            int prev = arrInt[0];
            StringBuilder output = new StringBuilder();
            for (int j : arrInt) {
                if (prev != j) {
                    output.append(prev).append(" ");
                    prev = j;
                }
            }
            output.append(prev).append(" ");
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String[] arr = get.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        deleteDuplicates(arrInt);
    }
}
