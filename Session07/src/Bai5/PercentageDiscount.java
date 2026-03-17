package Bai5;

class PercentageDiscount implements DiscountStrategy {

    double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double amount) {
        return amount * percent / 100;
    }
}
