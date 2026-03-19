package Bai6;


class WebsiteDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.1;
    } // Giảm 10%
}
