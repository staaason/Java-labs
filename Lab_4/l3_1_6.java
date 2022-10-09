public class l3_1_6 {

    public static String smallest(String[] words) {
        if (words == null || words.length < 1) {
            return "No numbers";
        }
        String smallest = words[0];
        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < smallest.length()) {
                smallest = words[i];
            }
            if(words[i].length() == smallest.length()){
                outputBuilder.append(words[i]).append(" ");
            }

        }

        String output = outputBuilder.toString();
        if(words[0].length() == smallest.length()){
            output += words[0] + " ";
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 1, 31, 4, 500, 1000, 55};
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrStr[i] = String.valueOf(arr[i]);
        }
        System.out.println(smallest(arrStr));
    }
}
