package Implementation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.sql.*;


import static java.sql.DriverManager.getConnection;

public class DBConnector {
    private static Connection con = null; // Changed to private static

    public static Connection ConnectionDB() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            con = getConnection("jdbc:mysql://localhost:3306/cs26", "root", "");
            System.out.println("Connection Succeeded");
            return con;
        } catch (Exception e) {
            // Show a GUI error message and print stack trace if connection fails
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Connection Failed: " + e.getMessage());
            return null;
        }


    }

    public static void main(String[] args) {
        Connection con = ConnectionDB();
    }

    public static int getStockByBreedName(String productName) {
        int stock = 0; // Default stock value
        try {
            Connection con = ConnectionDB();
            String query = "SELECT quantity FROM BreedInventory WHERE breed = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, productName); // Set the product name
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("quantity"); // Get the stock value
            }
        } catch (SQLException e) {
            System.out.println("Error fetching stock for " + productName + ": " + e.getMessage());
        }
        return stock;
    }

    public static int getStockByPetFoodName(String productName) {
        int stock = 0; // Default stock value
        try {
            Connection con = ConnectionDB();
            String query = "SELECT quantity FROM PetFoodInventory WHERE product = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, productName); // Set the product name
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("quantity"); // Get the stock value
            }
        } catch (SQLException e) {
            System.out.println("Error fetching stock for " + productName + ": " + e.getMessage());
        }
        return stock;
    }

    public static int getStockByAccessoriesName(String productName) {
        int stock = 0; // Default stock value
        try {
            Connection con = ConnectionDB();
            String query = "SELECT quantity FROM AccessoriesInventory WHERE product = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, productName); // Set the product name
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                stock = rs.getInt("quantity"); // Get the stock value
            }
        } catch (SQLException e) {
            System.out.println("Error fetching stock for " + productName + ": " + e.getMessage());
        }
        return stock;
    }

    public static int AddStockByBreedName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the breed
            String fetchQuery = "SELECT quantity FROM BreedInventory WHERE breed = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value
                    updatedStock = currentStock + additionalStock; // Calculate updated stock
                } else {
                    System.out.println("Breed not found in inventory: " + productName);
                    return updatedStock; // Return 0 if breed not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE BreedInventory SET quantity = ? WHERE breed = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the breed name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }

    public static int AddStockByPetFoodName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the breed
            String fetchQuery = "SELECT quantity FROM PetFoodInventory WHERE product = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value
                    updatedStock = currentStock + additionalStock; // Calculate updated stock
                } else {
                    System.out.println("Product not found in inventory: " + productName);
                    return updatedStock; // Return 0 if breed not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE PetFoodInventory SET quantity = ? WHERE product = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the breed name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }

    public static int AddStockByAccessoriesName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the breed
            String fetchQuery = "SELECT quantity FROM AccessoriesInventory WHERE product = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value
                    updatedStock = currentStock + additionalStock; // Calculate updated stock
                } else {
                    System.out.println("Product not found in inventory: " + productName);
                    return updatedStock; // Return 0 if breed not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE AccessoriesInventory SET quantity = ? WHERE product = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the breed name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }

    // Success notification for stock update
    private static void showStockUpdateSuccessNotification(String breed, int updatedStock) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Stock Update Successful");
        alert.setHeaderText("Stock for " + breed + " Updated");
        alert.setContentText("The stock for " + breed + " has been updated successfully. New stock: " + updatedStock);
        alert.showAndWait();
    }

    public static int MinusStockByBreedName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the breed
            String fetchQuery = "SELECT quantity FROM BreedInventory WHERE breed = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value

                    // Calculate updated stock
                    updatedStock = currentStock - additionalStock;

                    // Ensure stock doesn't go below zero
                    if (updatedStock < 0) {
                        System.out.println("Cannot reduce stock for " + productName + " to negative. Current stock: " + currentStock + ", Attempted to reduce by: " + additionalStock);
                        return currentStock; // Return the current stock if attempted reduction is invalid
                    }
                } else {
                    System.out.println("Breed not found in inventory: " + productName);
                    return updatedStock; // Return 0 if breed not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE BreedInventory SET quantity = ? WHERE breed = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the breed name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }


    public static int MinusStockByPetFoodName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the product
            String fetchQuery = "SELECT quantity FROM PetFoodInventory WHERE product = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value

                    // Calculate updated stock
                    updatedStock = currentStock - additionalStock;

                    // Ensure stock doesn't go below zero
                    if (updatedStock < 0) {
                        System.out.println("Cannot reduce stock for " + productName + " to negative. Current stock: " + currentStock + ", Attempted to reduce by: " + additionalStock);
                        return currentStock; // Return the current stock if attempted reduction is invalid
                    }
                } else {
                    System.out.println("Product not found in inventory: " + productName);
                    return updatedStock; // Return 0 if product not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE PetFoodInventory SET quantity = ? WHERE product = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the product name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }


    public static int MinusStockByAccessoriesName(String productName, int additionalStock) {
        int updatedStock = 0;

        try (Connection con = ConnectionDB()) { // Use try-with-resources to close the connection
            // First, fetch the current stock for the product
            String fetchQuery = "SELECT quantity FROM AccessoriesInventory WHERE product = ?";
            try (PreparedStatement fetchPst = con.prepareStatement(fetchQuery)) {
                fetchPst.setString(1, productName);
                ResultSet rs = fetchPst.executeQuery();

                if (rs.next()) {
                    int currentStock = rs.getInt("quantity"); // Get the current stock value

                    // Calculate updated stock
                    updatedStock = currentStock - additionalStock;

                    // Ensure stock doesn't go below zero
                    if (updatedStock < 0) {
                        System.out.println("Cannot reduce stock for " + productName + " to negative. Current stock: " + currentStock + ", Attempted to reduce by: " + additionalStock);
                        return currentStock; // Return the current stock if attempted reduction is invalid
                    }
                } else {
                    System.out.println("Product not found in inventory: " + productName);
                    return updatedStock; // Return 0 if product not found
                }

                // Now, update the stock in the database
                String updateQuery = "UPDATE AccessoriesInventory SET quantity = ? WHERE product = ?";
                try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                    updatePst.setInt(1, updatedStock); // Set the new stock value
                    updatePst.setString(2, productName); // Set the product name
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        // If the update was successful, show success notification
                        showStockUpdateSuccessNotification(productName, updatedStock);
                    } else {
                        System.out.println("Failed to update stock for " + productName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating stock for " + productName + ": " + e.getMessage());
        }

        return updatedStock; // Return the updated stock value
    }


    public static boolean AddSales(String product, int quantity, double grossIncome, String saleDate) {
        boolean isAdded = false; // Tracks if the insertion was successful

        try (Connection con = ConnectionDB()) { // Use try-with-resources for auto-closing
            // Prepare the SQL query for inserting a new sale
            String insertQuery = "INSERT INTO Sales (Product, Quantity, Gross_Income, date) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                // Set the parameters for the prepared statement
                pst.setString(1, product);
                pst.setInt(2, quantity);
                pst.setDouble(3, grossIncome);
                pst.setString(4, saleDate);

                // Execute the query
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    isAdded = true; // Mark as successful
                    System.out.println("Sale added successfully for product: " + product);
                } else {
                    System.out.println("Failed to add sale for product: " + product);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error adding sale for product: " + product + ". Error: " + e.getMessage());
        }

        return isAdded; // Return success status
    }
    public static ObservableList<SalesRecord> loadSalesData() {
        ObservableList<SalesRecord> salesList = FXCollections.observableArrayList();

        String query = "SELECT Product, Quantity, Gross_Income, date FROM Sales";

        try (Connection con = ConnectionDB();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String productName = rs.getString("Product");
                int quantity = rs.getInt("Quantity");
                double grossIncome = rs.getDouble("Gross_Income");
                String saleDate = rs.getString("date");

                SalesRecord record = new SalesRecord(productName, quantity, grossIncome, saleDate);
                salesList.add(record);
            }
        } catch (SQLException e) {
            System.out.println("Error loading sales data: " + e.getMessage());
        }

        return salesList;
    }
}

