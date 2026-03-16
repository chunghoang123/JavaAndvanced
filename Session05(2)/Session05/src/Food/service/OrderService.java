package Food.service;

import Food.exception.InsufficientStockException;
import Food.exception.InvalidOrderIdException;
import Food.model.*;
import Food.model.Order;

import java.util.*;

public class OrderService {
    private static Scanner sc = new Scanner(System.in);
    private List<Order> orders = new ArrayList<>();
    private List<MenuItem> menuItems;

    public OrderService(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public List<Order> getOrders() { return orders; }

    //  Tạo đơn hàng (ID tự sinh)
    public Order createOrder(String customerName) {
        Order order = new Order(customerName);
        orders.add(order);
        System.out.println("Tao don thanh cong! ID: " + order.getOrderId());
        return order;
    }
    // Add to item
    public void addItemToOrder(String orderId,
                               String menuItemId,
                               int    quantity)
            throws InvalidOrderIdException,
            InsufficientStockException {

        // Bước 1: Tìm đơn hàng
        Optional<Order> orderOpt = orders.stream()
                .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                .findFirst();

        if (!orderOpt.isPresent()) {
            throw new InvalidOrderIdException(orderId);
        }
        Order order = orderOpt.get();

        // Bước 2: Tìm món ăn
        Optional<MenuItem> itemOpt = menuItems.stream()
                .filter(i -> i.getId().equalsIgnoreCase(menuItemId))
                .findFirst();

        if (!itemOpt.isPresent()) {
            throw new InvalidOrderIdException(menuItemId);
        }
        MenuItem item = itemOpt.get();

        // Bước 3: Kiểm tra tồn kho
        if (item.getStock() < quantity) {
            throw new InsufficientStockException(item.getName(), item.getStock());
        }

        // Bước 4: Thêm vào đơn (nếu có rồi thì cộng dồn)
        order.getItems().merge(item, quantity, Integer::sum);

        // Bước 5: Trừ tồn kho
        item.setStock(item.getStock() - quantity);

        // Bước 6: Thông báo
        System.out.println("=====================================");
        System.out.println("Da them thanh cong!");
        System.out.printf("  Mon an  : %s%n",         item.getName());
        System.out.printf("  So luong: %d%n",          quantity);
        System.out.printf("  Don gia : %,.0f VND%n",   item.calculatePrice());
        System.out.printf("  Thanh tien: %,.0f VND%n", item.calculatePrice() * quantity);
        System.out.println("-------------------------------------");
        System.out.printf("  Tong don [%s]: %,.0f VND%n",
                order.getOrderId(), order.getTotalPrice());
        System.out.println("=====================================");
    }
    public class CreateOrder {

        private static int count = 1;

        public Order createOrder(List<Order> orders) {

            try {

                System.out.print("Nhap ten khach hang: ");
                String customerName = sc.nextLine();

                Order order = new Order(customerName);

                orders.add(order);

                System.out.println("Create order success! Order ID: " + order.getOrderId());

                return order;

            } catch (Exception e) {

                System.out.println("Error while creating order: " + e.getMessage());
                return null;

            }
        }
    }
    public void payOrder(String orderId) throws InvalidOrderIdException {
        Order order = orders.stream()
                .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                .findFirst()
                .orElseThrow(() -> new InvalidOrderIdException(orderId));

        order.setStatus(OrderStatus.PAID);
    }
    public void cancelOrder(String orderId) throws InvalidOrderIdException {
        Order order = orders.stream()
                .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                .findFirst()
                .orElseThrow(() -> new InvalidOrderIdException(orderId));

        order.setStatus(OrderStatus.CANCELLED);
    }
}