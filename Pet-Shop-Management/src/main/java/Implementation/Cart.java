package Implementation;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static Cart instance; // Singleton instance of Cart

    private List<CartItem> cartItems;

    // Private constructor to ensure Singleton pattern
    private Cart() {
        this.cartItems = new ArrayList<>();
    }

    // Public method to get the singleton instance of Cart
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // CartItem class to represent each item in the cart
    private class CartItem {
        Product product;
        int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        // Calculate total price for a cart item
        public double getTotalPrice() {
            return product.getPrice() * quantity;
        }

        // Update the quantity of an existing item
        public void updateQuantity(int newQuantity) {
            this.quantity = newQuantity;
        }

        // Get the quantity of a product in the cart
        public int getQuantity() {
            return this.quantity;
        }
    }

    // Add a product to the cart or update the quantity if it already exists
    public void addProduct(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.product.equals(product)) {
                item.updateQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    // Update the quantity of a product in the cart
    public void updateProductQuantity(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.product.equals(product)) {
                if (newQuantity <= 0) {
                    cartItems.remove(item);
                } else {
                    item.updateQuantity(newQuantity);
                }
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    // Calculate the total price of all items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public String getCartDetails() {
        StringBuilder sb = new StringBuilder();

        if (cartItems.isEmpty()) {
            sb.append("The cart is empty.\n");
        } else {
            // Header with wider spacing
            sb.append(String.format("%-45s %-45s %-45s%n", "Products", "Quantity", "Price"));
            sb.append("-------------------------------------------------------------------------------------------------------------\n");

            // Cart items with extended spacing
            for (CartItem item : cartItems) {
                sb.append(String.format("%-45s %-45d $%-44.2f%n",
                        item.product.getName(), item.quantity, item.getTotalPrice()));
            }

            // Footer with wider spacing
            sb.append("-------------------------------------------------------------------------------------------------------------\n");
            sb.append(String.format("%-90s $%-44.2f%n", "Total:", calculateTotal()));
        }

        return sb.toString();
    }






    // Clear all items in the cart
    public void clear() {
        cartItems.clear();
    }
}
