import Edition.Dictionary;
import Edition.Encyclopedia;

public class l8_7_1 {
    public static void main(String[] args) {
        Dictionary d = new Dictionary("Dictionary", 423, "Author1, Author2", 124,
                "English", "Ukrainian", 100);
        Encyclopedia e = new Encyclopedia("Encyclopedia", 233, "Author3", 500, 100);
        System.out.println(d);
        System.out.println(e);
    }

}
