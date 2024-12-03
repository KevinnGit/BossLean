package Implementation;

public class SalesRecord {
    private String productName;
    private int quantity;
    private double grossIncome;
    private String saleDate;

    // Constructor
    public SalesRecord(String productName, int quantity, double grossIncome, String saleDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.grossIncome = grossIncome;
        this.saleDate = saleDate;
    }

    // Getters for properties
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public String getSaleDate() {
        return saleDate;
    }
}
