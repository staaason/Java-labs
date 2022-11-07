package Flower;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lily extends Flower{
    public Lily(double price, Date date, double length) {
        super(price, date, length);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
        return "Lily"  + ", price:" + getPrice() + ", length: " + getLength() + ", date: " +
                simpleDateFormat.format(getDate());
    }
}
