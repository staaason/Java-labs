import java.util.Scanner;

public class l2_2_11 {

    public static int add(int num1, int num2){
        int carry = 0x00;
        while(num2 != 0x00){
            carry = (num1 & num2);
            num1 = num1 ^ num2;
            num2 = (carry << 1);
        }
        return num1;
    }

    public static int sub(int num1, int num2){
        int carry = 0x00;
        while(num2 != 0x00){
            carry = ((~num1) & num2);
            num1 = num1 ^ num2;
            num2 = (carry << 1);
        }
        return num1;

    }

    public static int mul(int num1, int num2){
        int result = 0;
        while(num2 != 0){
            if((num2 & 1) == 1){
                result = add(result, num1);
            }
            num1 <<= 1;
            num2 >>= 1;
        }

        return result;
    }

    public static int div(int dividend, int divisor) {
        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { 
            negative = !negative;
            dividend = add(~dividend, 1);
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = add(~divisor, 1);
        }
        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            r = (divisor << i);
            if (r < Integer.MAX_VALUE && r >= 0) { 
                if (r <= dividend) {
                    quotient |= (1 << i);
                    dividend = sub(dividend, (int) r);
                }
            }
        }
        if (negative) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }

    public static int mod(int num1, int num2){
        return num1 & (num2 - 1);
    }

    public static void main(String[] args) {
        System.out.println("Введіть числа x та y: ");
        int x, y;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.printf("Додавання чисел %d та %d : %d\n", x, y, add(x, y));
        System.out.printf("Віднімання чисел %d та %d : %d\n", x, y, sub(x, y));
        System.out.printf("Множення чисел %d та %d : %d\n", x, y, mul(x, y));
        System.out.printf("Ділення чисел %d та %d : %d\n", x, y, div(x, y));
        System.out.printf("Остача чисел %d та %d : %d\n", x, y, mod(x, y));
    }
}
