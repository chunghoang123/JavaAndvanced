package Bai1;

public class OrderCalculator {
    public double calculateTotal(Order order){
        double total = 0;
        for (Product p : order.products){
            total += p.peice;
        }
        order.totalAmount = total;
        return  total;
    }
}
