package Bai6;

/* Website */
class WebsiteDiscount implements DiscountStrategy {

    String code;

    public WebsiteDiscount(String code) {
        this.code = code;
    }

    public double apply(double total) {

        if (code.equalsIgnoreCase("WEB10")) {
            System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
            return total * 0.1;
        }

        return 0;
    }
}
