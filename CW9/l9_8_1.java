import Payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class l9_8_1 {
    public static void main(String[] args){

        Payment payment = new Payment();
        payment.addProduct("Bread", 28);
        payment.addProduct("Beer", 32.99);
        payment.addProduct("Milk", 40.2);
        System.out.println(payment);
        System.out.println("Price: " + payment.priceOfPayment());
    }
}
