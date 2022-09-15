import java.util.Scanner;

public class l1_6 {
    public static void main(String[] args) {
        double par1 = 0;


        for(String str : args){
            par1 += Double.parseDouble(str);
        }

        System.out.print(par1);
    }
}
