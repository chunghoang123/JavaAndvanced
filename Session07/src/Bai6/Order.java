package Bai6;

import java.util.ArrayList;
import java.util.List;

class Order {
    List<OrderItem> items = new ArrayList<>();

    void addItem(OrderItem item) {
        items.add(item);
    }

    double getTotal() {
        double total = 0;
        for (OrderItem i : items) {
            total += i.getTotal();
        }
        return total;
    }
}
