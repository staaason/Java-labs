import java.util.Scanner;

public class l2_2 {
    static float harmonicMean(int arr[], int n)
    {
        float sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + (float)1 / arr[i];
        return (float)n / sum;
    }
    public static void main(String[] args) {
        int x,y;

        Scanner sc = new Scanner(System.in);
        String ln =  sc.nextLine();
        String[] splited = ln.trim().split("\\s+");
        x = Integer.parseInt(splited[0]);
        y = Integer.parseInt(splited[1]);
        int length_str = String.valueOf(x).length();
        System.out.print("Розрядність числа методом рядків : ");
        System.out.print(length_str);
        int length_log = (int) (Math.log10(x) + 1);
        System.out.print("\nРозрядність числа методом логарифма : ");
        System.out.print(length_log);
        int length_str2 = String.valueOf(y).length();
        System.out.print("\nРозрядність числа методом рядків : ");
        System.out.print(length_str2);
        int length_log2 = (int) (Math.log10(y) + 1);
        System.out.print("\nРозрядність числа методом логарифма : ");
        System.out.print(length_log2);
        int [] tempArr = {x,y};
        System.out.printf("\n %.2f \n",harmonicMean(tempArr,tempArr.length));


    }
}
