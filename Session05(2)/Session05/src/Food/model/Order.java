package Food.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {

    // Bộ đếm tự động: ORD001, ORD002, ORD003...
    private static int counter = 1;

    private String orderId;
    private String customerName;
    private Map<MenuItem, Integer> items;
    private OrderStatus status;

    // Constructor – KHÔNG cần truyền ID, tự sinh
    public Order(String customerName) {
        this.orderId      = "ORD" + String.format("%03d", counter++);
        this.customerName = customerName;
        this.items        = new LinkedHashMap<>();
        this.status       = OrderStatus.PENDING;
    }

    // Getter / Setter
    public String getOrderId()
    {
        return orderId;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public Map<MenuItem, Integer> getItems()
    {
        return items;
    }
    public OrderStatus getStatus()
    {
        return status;
    }
    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    // Tính tổng tiền
    public double getTotalPrice() {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getKey().calculatePrice() * e.getValue())
                .sum();
    }

    // In thông tin đơn
    @Override
    public String toString() {
        return String.format("%s | %-15s | %,.0f VND | %s",
                orderId, customerName, getTotalPrice(), status);
    }
}