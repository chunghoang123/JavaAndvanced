package Bai5;

class CreditCardPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng: " + amount);
    }

    static class Customer {
        String name;
        String email;
        String phone;

        public Customer(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }
    }
}
