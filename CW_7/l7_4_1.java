import Polynom.Polynom;
import com.fraction.RationalFraction;

import java.util.ArrayList;
import java.util.List;

public class l7_4_1 {
    public static void main(String[] args){
        List<RationalFraction> list = new ArrayList<>(){
            {
                add(new RationalFraction(4, 10));
                add(new RationalFraction(3, 5));
                add(new RationalFraction(2, 3));
                add(new RationalFraction(4, 6));
            }
        };
        List<RationalFraction> list2 = new ArrayList<>(){
            {
                add(new RationalFraction(2, 10));
                add(new RationalFraction(5, 5));
                add(new RationalFraction(1, 3));
                add(new RationalFraction(8, 6));

            }
        };
        Polynom polynom1 = new Polynom(list);
        Polynom polynom2 = new Polynom(list2);
        System.out.println(polynom1.addPolynom(polynom2));
    }

}
