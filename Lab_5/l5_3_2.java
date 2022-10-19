public class l5_3_2 {
    static String str = "string 1";
    static String str2 = new String("string 1");

    public static void main(String[] args){
        System.out.println(str);
        System.out.println(str.equals(str2));
        System.out.println(str == str2); // різниця в тому, що ці об'єкти різні тому, що посилаються на два різні елементи в heap
    }
}
