import java.util.Scanner;

public class BlikPayment implements PaymentMethod{


    private String blikCode;
    private double balance;



    public BlikPayment(double balance, String blikCode) {

        if (!blikCode.matches("\\d{6}")){
            throw new IllegalArgumentException("Wrong blik code");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance is below 0");
        }

        this.balance = balance;
        this.blikCode = blikCode;
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
