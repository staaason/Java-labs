package Payment;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Payment {
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "products=" + products +
                '}';
    }



    public Payment() {}
    public double priceOfPayment(){
        return products.stream().mapToDouble(Product::getPrice).sum();
    };

    public void addProduct(String name,  double price){
        products.add(new Product(name, price));
    }

    ArrayList<Product> products = new ArrayList<>();
    private  class Product{
        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public void setPrice(double price) {
            this.price = price;
        }

        private double price;

    }
}
