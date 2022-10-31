import Complex.Complex;
import com.fraction.RationalFraction;

import java.util.ArrayList;
import java.util.List;

public class l7_4_5 {

    public static List<Complex> addComplex(List<Complex> arr) {
        List<Complex> temp = new ArrayList<Complex>();
        for (int i = 0; i < arr.size() - 1; i++) {
            temp.add(arr.get(i).addComplex(arr.get(i + 1)));
        }
        return temp;
    }

    public static List<Complex> mulComplex(List<Complex> arr) {
        List<Complex> temp = new ArrayList<Complex>();
        for (int i = 0; i < arr.size() - 1; i++) {
            temp.add(arr.get(i).mulComplex(arr.get(i + 1)));
        }
        return temp;

    }

    public static void main(String[] args) {
        List<Complex> arr = new ArrayList<>();
        arr.add(new Complex(new RationalFraction(1, 2), new RationalFraction(3, 4)));
        arr.add(new Complex(new RationalFraction(7, 4), new RationalFraction(9, 8)));
        arr.add(new Complex(new RationalFraction(11, 15), new RationalFraction(3, 4)));
        arr.add(new Complex(new RationalFraction(17, 2), new RationalFraction(8, 5)));
        arr.add(new Complex(new RationalFraction(1, 2), new RationalFraction(3, 4)));
        System.out.println(addComplex(arr));
        System.out.println(mulComplex(arr));
    }
}