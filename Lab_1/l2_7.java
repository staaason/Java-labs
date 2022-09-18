
public class l2_7 {
    public static void main(String[] args) {
        int output = 1;
        for (String par: args) {
            output *= Integer.parseInt(par);
        }
        System.out.println(output);
    }
}
