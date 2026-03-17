package Bai6;

/* Mobile */
class MobileDiscount implements DiscountStrategy {

    boolean firstTime;

    public MobileDiscount(boolean first) {
        firstTime = first;
    }

    public double apply(double total) {

        if (firstTime) {
            System.out.println("Áp dụng giảm giá 15% cho lần đầu");
            return total * 0.15;
        }

        return 0;
    }
}
