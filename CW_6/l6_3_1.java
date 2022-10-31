import com.fraction.*;
public class l6_3_1 {

    public static RationalFraction[] findSum(RationalFraction[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i].n != 0 && arr[i].m != 0){
                arr[i] = arr[i].add(arr[i+1]);
            }
        }
        return arr;
    }

    public static   void main(String[] args){
        int k = 5;
        RationalFraction[] a = new RationalFraction[k];
        a[0] = new RationalFraction(2,4);
        a[1] = new RationalFraction(3, 5);
        a[2] = new RationalFraction(11, 8);
        a[3] = new RationalFraction(5, 9);
        a[4] = new RationalFraction(0, 0);
        for(RationalFraction frac: a){
            System.out.println(frac);
        }
        System.out.println();
        for(RationalFraction frac: findSum(a)){
            System.out.println(frac);
        }

    }
}
