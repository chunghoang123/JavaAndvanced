package Bai5;

class HolidayDiscount implements DiscountStrategy {

    public double applyDiscount(double amount) {
        return amount * 0.2;
    }
}
