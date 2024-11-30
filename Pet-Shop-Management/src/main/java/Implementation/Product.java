package Implementation;

public class Product {
    private String name;
    private double price;
    private int stockQuantity;
    private String description;

    // Full constructor
    public Product(String name, double price, int stockQuantity, String description) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    // Partial constructor for products with no initial stock
    public Product(String name, double price, String description) {
        this(name, price, 0, description);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Method to decrease stock
    public boolean decreaseStock(int quantity) {
        if (quantity > 0 && quantity <= stockQuantity) {
            stockQuantity -= quantity;
            return true; // Successfully decreased stock
        }
        return false; // Insufficient stock or invalid quantity
    }

    // Method to increase stock
    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }
}
