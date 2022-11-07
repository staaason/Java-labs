package Flower;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rose extends Flower{
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
        return "Rose"  + ", price:" + getPrice() + ", length: " + getLength() + ", date: " +
                simpleDateFormat.format(getDate());
    }

    public Rose(double price, Date date, double length) {
        super(price, date, length);
    }
}
