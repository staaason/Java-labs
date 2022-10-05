public class l3_4_11 {

    public static void findArmstrongNum(int a, int b){
        int n;
        int digit;
        int result = 0;
        for(int i = a; i < b + 1; ++i){
            n = i;
            while(n != 0){
                digit = n % 10;
                result  = (int) (result  + Math.pow(digit, String.valueOf(i).length()));
                n = (int)(n/10);
            }
            if(result == i && i != 0){
                System.out.println(i);
            }
            result = 0;
        }

    }
    public static void main(String[] args){
        findArmstrongNum(0, 10000);
    }
}
