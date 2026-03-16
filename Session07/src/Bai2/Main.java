package Bai2;

public class Main {
    public static void main(String[] args) {
        double totalAmount = 1000000;

        // 1. Áp dụng PercentageDiscount 10%
        OrderCalculator calc = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Áp dụng PercentageDiscount 10%: " + (long)calc.calculateFinalAmount(totalAmount));

        // 2. Áp dụng FixedDiscount 50.000
        calc.setDiscountStrategy(new FixedDiscount(50000));
        System.out.println("Áp dụng FixedDiscount 50.000: " + (long)calc.calculateFinalAmount(totalAmount));

        // 3. Áp dụng NoDiscount
        calc.setDiscountStrategy(new NoDiscount());
        System.out.println("Áp dụng NoDiscount: " + (long)calc.calculateFinalAmount(totalAmount));

        // 4. Áp dụng HolidayDiscount mới (Không sửa code cũ)
        calc.setDiscountStrategy(new HolidayDiscount());
        System.out.println("Áp dụng HolidayDiscount 15%: " + (long)calc.calculateFinalAmount(totalAmount));
    }
}