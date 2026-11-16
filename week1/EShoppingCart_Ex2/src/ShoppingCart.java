import java.util.ArrayList;

/**
 * Shopping cart class store the product in ArrayList
 */
public class ShoppingCart {

    private final ArrayList<CartItem> cartItems = new ArrayList<>();


    public void addItem(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (CartItem existingItem : cartItems) {
            if (existingItem.getProductName().equals(item.getProductName())) {
                throw new IllegalArgumentException("Product already exists in cart");
            }
        }
        cartItems.add(item);
    }

    public void removeItem(String productName) {
        cartItems.removeIf(cartItems -> cartItems.getProductName().equals(productName));
    }

    public double calculateTotal() {
        double sum = 0;
        if (cartItems.isEmpty()){
            return sum;
        }
        for (CartItem cartItem : cartItems) {
            sum += (cartItem.getQuantity() * cartItem.getUnitPrice());
        }
        return sum;
    }

    public void printCart() {
        int i = 1;
        System.out.println("\n Your Cart: ");
        for (CartItem cartItem : cartItems) {
            System.out.println(i + ". " + cartItem.toString() + " Product Total: " + cartItem.getQuantity()*cartItem.getUnitPrice());
            i++;
        }
        System.out.println("Total: " + calculateTotal());
    }

}
