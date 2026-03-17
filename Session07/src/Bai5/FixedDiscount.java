package Bai5;

class FixedDiscount implements DiscountStrategy {

    double value;

    public FixedDiscount(double value) {
        this.value = value;
    }

    public double applyDiscount(double amount) {
        return value;
    }
}
