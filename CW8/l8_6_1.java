import Flower.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class l8_6_1 {
    public static void main(String[] args) throws ParseException {
        try{
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM");
            ArrayList<Flower> flowers = new ArrayList<>(){
                {
                    add(new Lily(45, ft.parse("11-11"), 13));
                    add(new Lily(52, ft.parse("13-11"), 15));
                    add(new Rose(50, ft.parse("12-11"), 14));
                    add(new Lily(45, ft.parse("13-11"), 20));
                    add(new Sunflower(30, ft.parse("10-11"), 15));
                }
            };
            Bouquet bouquet = new Bouquet(flowers);
            bouquet.sortFlowersByDate();
            System.out.println("Bouquet:\n" + bouquet);
            System.out.println("Ціна букету: " + bouquet.getPrice());
            System.out.printf("Flower with length from %d to %d : " + bouquet.findFlowerByLength(15, 20), 15, 20);
        }catch (ParseException e){
            System.out.println(e.getMessage());
        }
    }
}
