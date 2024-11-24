package Implementation;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private class CartItem {
        Product product;
        int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return product.getPrice() * quantity;
        }

        public void updateQuantity(int newQuantity) {
            this.quantity = newQuantity;
        }

        public int getQuantity() {
            return this.quantity;
        }
    }

    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    // Add a product with a specific quantity to the cart
    public void addProduct(Product product, int quantity) {
        // Check if the product already exists in the cart
        for (CartItem item : cartItems) {
            if (item.product.equals(product)) {
                item.updateQuantity(item.getQuantity() + quantity); // Increase the quantity if product already exists
                return;
            }
        }
        // If product doesn't exist, add it to the cart
        cartItems.add(new CartItem(product, quantity));
    }

    // Remove or update the quantity of a product from the cart
    public void updateProductQuantity(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.product.equals(product)) {
                if (newQuantity <= 0) {
                    cartItems.remove(item); // Remove the product if quantity is 0 or less
                } else {
                    item.updateQuantity(newQuantity); // Update the quantity
                }
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    // Get the total cost of all items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Get the formatted cart string for display in TextArea
    public String getCartDetails() {
        StringBuilder sb = new StringBuilder();

        if (cartItems.isEmpty()) {
            sb.append("The cart is empty.\n");
        } else {
            // Add header
            sb.append(String.format("%-30s %-15s %-15s %-10s%n", "Product Name", "Quantity", "Price (Each)", "Total Price"));
            sb.append("-------------------------------------------------------------------\n");

            // Add each product's details
            for (CartItem item : cartItems) {
                sb.append(String.format("%-30s %-15d $%-14.2f $%-10.2f%n",
                        item.product.getName(), item.quantity, item.product.getPrice(), item.getTotalPrice()));
            }

            // Add total cost
            sb.append("-------------------------------------------------------------------\n");
            sb.append(String.format("%60s $%-10.2f%n", "Total Price:", calculateTotal()));
        }

        return sb.toString();
    }
}
