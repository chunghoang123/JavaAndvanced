package Bai5;

import java.util.ArrayList;
import java.util.List;

class DatabaseOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu DB đơn hàng " + order.id);
    }

    public List<Order> findAll() {
        return orders;
    }
}
