package Bai2;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;

    // Thiết lập chiến lược giảm giá thông qua Constructor
    public OrderCalculator(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    // Hoặc thay đổi chiến lược linh hoạt qua Setter
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double calculateFinalAmount(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}