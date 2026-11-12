public class CardPayment implements PaymentMethod{


    private double balance;

    public CardPayment(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance is below 0");
        }

        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Wrong amount of transaction");
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Payment done!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Your balance: " + balance + "\u0024";
    }
}
