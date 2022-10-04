import java.util.Random;

public class l2_2_3 {
    public static void main(String[] args) {
        char ch = 'a';
        int ascii =  ch;
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((ascii & mask) != 0 ? "1" : "0");
        }

        System.out.println(result);
        String s = Integer.toBinaryString(ascii);
        System.out.println(s);
    }
}
