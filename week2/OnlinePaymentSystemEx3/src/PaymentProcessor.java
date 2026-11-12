public class PaymentProcessor{
    public boolean processPayment(PaymentMethod method, double amount) {
        return method.pay(amount);
    }
}
