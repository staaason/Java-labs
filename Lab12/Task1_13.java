package Lab12;

public class Task1_13 {
    /*
    13.Не використовуючи допоміжних об'єктів, переставити відємні елементи даного списку в кінець,
    а додатні - в початок цього списку.
    */
    public static void main(String[] args) {
        int[] arr = {4,5,8,-7,-1,-5,9,4,2,-8,3,-11,6};
        int x = 0;
        for (int i = 0;i < arr.length; i++) {
            if (arr[i] < x) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] > x) {
                        arr[i] = arr[i] + arr[j] -(arr[j] = arr[i]) ;
                        break;
                    }
                }
            }
        }
        for (int i:arr)
            System.out.printf("%d ", i);

    }
}
