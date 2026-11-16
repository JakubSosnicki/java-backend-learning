
void main() {

    Product product = new Product(101,"Keyboard",150,10);
    product.addStock(5);
    product.toString();
    product.removeStock(3);
    //product.removeStock(20);
    IO.println(product.getInventoryValue());
    System.out.printf(product.toString());

}
