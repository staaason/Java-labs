import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class l10_3_11 {

    public static Map<Character, Integer> buildMapOfGroups(String src) {

        return src.chars()
                .mapToObj(c -> (char) c)
                .map(c -> Map.entry(
                        c,
                        Pattern.compile(c + "+").matcher(src)
                                .results()
                                .map(r -> r.group().length())
                                .mapToInt(Integer::intValue)
                                .max()
                                .getAsInt()
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }




    public static void main(String[] args){
        String string = "399999 srsss bobba";
        String[] strings = string.split("\\s+");
        Map<String, Map<Character, Integer>> map = Stream.of(strings).
                map(s -> Map.entry(s, buildMapOfGroups(s))).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        Map.Entry<String, Map<Character, Integer>> stringMapEntry = null;
        for (Map.Entry<String, Map<Character, Integer>> entry: map.entrySet()) {
            for(Map.Entry<Character, Integer> entry1: entry.getValue().entrySet()){
                if (stringMapEntry == null || entry1.getValue()
                        .compareTo(stringMapEntry
                                .getValue()
                                .values()
                                .stream()
                                .mapToInt(integer -> integer)
                                .max()
                                .getAsInt()) > 0) {
                    stringMapEntry = entry;
                }
            }
        }
        System.out.println(map);
        System.out.println(stringMapEntry);
        int maxRep = Collections.max(stringMapEntry.getValue().values());
        List<Character> list = stringMapEntry.
                getValue().
                entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxRep))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        string = string.replaceAll(String.valueOf(list.get(0)).repeat(maxRep), "");
        System.out.println(string);
    }
}
