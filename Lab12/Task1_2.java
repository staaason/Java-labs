package Lab12;

import java.util.Stack;

public class Task1_2 {
    /*
        2. Ввести число, занести його цифри в стек. Вивести число, у якого цифри йдуть в зворотному порядку.
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int num = 12345;
        while(num > 1) {
            int a = num % 10;
            stack.push(a);
            num /= 10;
        }
        StringBuilder number = new StringBuilder();
        for(Integer n:stack)
            number.append(n);
        System.out.println(Integer.parseInt(number.toString()));
    }
}
