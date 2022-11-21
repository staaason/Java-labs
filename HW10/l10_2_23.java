import java.util.stream.Stream;



public class l10_2_23 {
    public static boolean startsAndEnds(String s){
        String start = String.valueOf(s.charAt(0));
        return (s.startsWith(start) == s.endsWith(start)) && s.length() >= 2;
    }

    public static void main(String[] args){
        String string = "A word that m has multiplm choicec";
        String[] strings = string.split("([\\W\\s]+)");
        String c = "m";
        System.out.println("Кількість слів: " + strings.length);
        long wordsStartsCh = Stream.of(strings).filter(s -> s.toLowerCase().startsWith(c) && s.length() >= 2)
                .count();
        long wordsEndsCh = Stream.of(strings).filter(s -> s.toLowerCase().endsWith(c) && s.length() >= 2)
                .count();
        long wordsStartsEndsCh = Stream.of(strings).
                filter(s -> s.toLowerCase().endsWith(c) && s.toLowerCase().startsWith(c) && s.length() >= 2)
                .count();
        long wordsStartsEndsSame = Stream.of(strings).
                filter(l10_2_23::startsAndEnds).count();
        System.out.printf("Кількість слів, що починаються з символа %s: %d", c, wordsStartsCh);
        System.out.printf("\nКількість слів, що закінчуються  символом  %s: %d", c, wordsEndsCh);
        System.out.printf("\nКількість слів, що  починаються з символа та закінчуються  %s: %d", c, wordsStartsEndsCh);
        System.out.printf("\nКількість слів, що  починаються з символа та закінчуються  однаковим символом: %d\n",
                wordsStartsEndsSame);

    }
}
