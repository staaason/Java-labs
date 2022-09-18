import java.util.Scanner;

public class l2_3 {
    static double geometricMean(double arr[], int n)
    {
        double product = 1;
        for (int i = 0; i < n; i++)
            product = product * arr[i];
        double gm = (double)Math.pow(product, (float)1 / n);
        return gm;
    }
    public static void main(String[] args) {
        double x,y;

        Scanner sc = new Scanner(System.in);
        String ln =  sc.nextLine();
        String[] splited = ln.trim().split("\\s+");
        x = Double.parseDouble(splited[0]);
        y = Double.parseDouble(splited[1]);
        double [] tempArr = {x,y};
        System.out.printf("%e %f \n", geometricMean(tempArr,tempArr.length), geometricMean(tempArr,tempArr.length));


    }
}
