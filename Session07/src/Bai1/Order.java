package Bai1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    String orderId;
    Customer customer;
    List<Product> products = new ArrayList<>();
    double totalAmount;


    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product p){
        products.add(p);

    }
}
