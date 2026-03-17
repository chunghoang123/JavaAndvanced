package Bai6;

class OrderItem {
    Product product;
    int quantity;

    public OrderItem(Product p, int q) {
        product = p;
        quantity = q;
    }

    double getTotal() {
        return product.price * quantity;
    }
}
