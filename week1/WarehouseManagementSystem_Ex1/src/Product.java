/**
 * Product class including key fields and functionality
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {

        if(price < 0 || quantity < 0){
            throw new IllegalArgumentException("Price or quantity below 0");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void addStock(int amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Amount of order is 0 or under");
        quantity+=amount;
    }

    public void removeStock(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount is negative is not possible");
        }
        if (quantity < amount){
            throw new IllegalArgumentException("Amount of order is too high");
        }
        quantity-=amount;
    }

    public double getInventoryValue() {
        return price*quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + "\u20AC" +
                ", quantity=" + quantity +
                '}';
    }


}
