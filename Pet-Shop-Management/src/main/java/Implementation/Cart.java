package Implementation;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static Cart instance;  // Singleton instance of Cart
    private List<CartItem> cartItems;

    private Cart() {
        this.cartItems = new ArrayList<>();
    }

    // Singleton access method
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    // Method to add a product to the cart
    public void addProduct(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.updateQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    // Method to get the list of CartItems
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // Calculate total price for all items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Clear the cart
    public void clear() {
        cartItems.clear();
    }

    public void removeCartItem(CartItem item) {
        cartItems.remove(item); // Removes the item from the list
    }
}
