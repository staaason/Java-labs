import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class l3_1_4 {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        String[] arr = get.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        Map<Integer,Integer> hm = new HashMap();
        for(int x: arrInt){

            if(!hm.containsKey(x)){
                hm.put(x,1);
            }else{
                hm.put(x, hm.get(x) + 1);
            }
        }
        System.out.println(hm);


    }
}
