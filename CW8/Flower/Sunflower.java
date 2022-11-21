package Flower;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sunflower extends Flower {
    public Sunflower(double price, Date date, double length) {
        super(price, date, length);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
        return "Sunflower"  + ", price:" + getPrice() + ", length: " + getLength() + ", date: " +
                simpleDateFormat.format(getDate());
    }
}
