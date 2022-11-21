package Flower;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flower{
    private double price;

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
        return "Flower{" +
                "price=" + price +
                ", date=" + simpleDateFormat.format(getDate()) +
                ", length=" + length +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private Date date;

    public Flower(double price, Date date, double length) {
        this.price = price;
        this.date = date;
        this.length = length;
    }

    private double length;
}
