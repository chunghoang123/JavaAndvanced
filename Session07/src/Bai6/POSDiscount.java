package Bai6;

/* POS */
class POSDiscount implements DiscountStrategy {

    boolean member;

    public POSDiscount(boolean member) {
        this.member = member;
    }

    public double apply(double total) {

        if (member) {
            System.out.println("Giảm giá 5% cho thành viên");
            return total * 0.05;
        }

        return 0;
    }
}
