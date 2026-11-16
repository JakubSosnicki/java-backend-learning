
void main() {
    CartItem mouse = new CartItem("Mouse", 80, 2);
    CartItem keyboard = new CartItem("Keyboard", 150, 1);
    CartItem monitor = new CartItem("Monitor", 900, 1);

    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addItem(mouse);
    shoppingCart.addItem(keyboard);
    shoppingCart.addItem(monitor);

    shoppingCart.removeItem("Keyboard");

    shoppingCart.calculateTotal();


    shoppingCart.printCart();

}
