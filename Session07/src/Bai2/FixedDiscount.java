package Bai2;

public class FixedDiscount implements DiscountStrategy {
    private double amoutn;
    public FixedDiscount(double amoutn){
        this.amoutn = amoutn;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - amoutn;
    }
}
