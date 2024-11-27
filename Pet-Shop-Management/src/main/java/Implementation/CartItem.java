package Implementation;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartItem {

    private Product product;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty totalPrice;
    private SimpleStringProperty productName;

    // Constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = new SimpleIntegerProperty(quantity);
        this.productName = new SimpleStringProperty(product.getName());
        this.totalPrice = new SimpleDoubleProperty(product.getPrice() * quantity);
    }

    // Getters for properties
    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public SimpleDoubleProperty totalPriceProperty() {
        return totalPrice;
    }

    // Getters for values (to be used directly when needed)
    public String getProductName() {
        return product.getName();
    }

    public int getQuantity() {
        return this.quantity.get();
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    // Update quantity and recalculate total price
    public void updateQuantity(int newQuantity) {
        this.quantity.set(newQuantity);
        this.totalPrice.set(product.getPrice() * newQuantity);
    }
    public Product getProduct() {
        return this.product;
    }
}
