import java.util.Scanner;

void main() {

    PaymentMethod cardPayment = new CardPayment(1000);
    PaymentMethod blikPayment= new BlikPayment(1000, "000000");
    PaymentProcessor paymentProcessor = new PaymentProcessor();

    System.out.println(cardPayment);
    if(paymentProcessor.processPayment(cardPayment, 400)){
        System.out.println(cardPayment);
    } else {
        System.out.println("Balance is to low");
    }

    System.out.println(blikPayment);
    if(paymentProcessor.processPayment(blikPayment, 400)){
         System.out.println(blikPayment);
    } else {
         System.out.println("Balance is to low");
    }

}
