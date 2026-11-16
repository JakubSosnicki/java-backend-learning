/**
 * Cart Item class describe product in shop
 */
public class CartItem {


    public CartItem(String productName, double unitPrice, int quantity) {
        if (productName == null)
            throw new IllegalArgumentException("Product name is null");

        if (unitPrice < 0 || quantity <= 0){
            throw new IllegalArgumentException("Amount of unitPrice below or equal 0 or quantity below 0");
        }
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;


    }

    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return productName +
                ", price=" + unitPrice + "\u20AC" +
                ", quantity=" + quantity;
    }
}
