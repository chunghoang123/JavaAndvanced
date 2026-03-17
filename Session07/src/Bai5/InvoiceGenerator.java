package Bai5;

class InvoiceGenerator {

    public static void generate(Order order, double discount) {

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: " + order.customer.name);

        for (OrderItem item : order.items) {

            System.out.println(
                    item.product.id +
                            " - Số lượng: " + item.quantity +
                            " - Đơn giá: " + item.product.price +
                            " - Thành tiền: " + item.getTotal()
            );
        }

        double total = order.getTotal();

        System.out.println("Tổng tiền: " + total);
        System.out.println("Giảm giá: " + discount);
        System.out.println("Cần thanh toán: " + (total - discount));
    }
}
