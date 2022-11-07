package Flower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Bouquet {
    private ArrayList<Flower> flowers;

    public Bouquet(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public double getPrice(){
        double price = 0;
        for (Flower flower: flowers) {
            price += flower.getPrice();
        }
        return price;
    }

    public void sortFlowersByDate(){
        FlowerComparatorByDate comparatorByDate = new FlowerComparatorByDate();
        flowers.sort(comparatorByDate);
    }

    public Flower findFlowerByLength(double a, double b){
        for(Flower flower: flowers){
            if(flower.getLength() >= a && flower.getLength() <= b){
                return flower;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + flowers +
                '}';
    }
}
