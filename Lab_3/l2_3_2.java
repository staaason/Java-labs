import java.util.Random;

public class l2_3_2 {
    public static void main(String[] args) {
        Random random1 = new Random();
        int [] arr = random1.ints(25, 1, 100).toArray();
        for (int j: arr
             ) {
         System.out.println(j);

        }
        for(int i = 0; i  < arr.length; ++i){
            for(int j = i; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    System.out.printf("%d менше %d\n", arr[i], arr[j]);
                }else if(arr[i] > arr[j]){
                    System.out.printf("%d більше %d\n", arr[i], arr[j]);
                }else{
                    System.out.printf("%d дорівнює %d\n", arr[i], arr[j]);
                }

            }


        }


    }
}
