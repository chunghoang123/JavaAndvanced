package Bai6;

class MobileFirstTimeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.15;
    } // Giảm 15%
}
