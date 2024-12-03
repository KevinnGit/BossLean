package Controller;

import Implementation.DBConnector;
import Implementation.SalesRecord;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class adminSalesController {

    @FXML
    private TableView<SalesRecord> SalesHistory;

    @FXML
    private AnchorPane adminSalesPane;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> grossIncomeColumn;

    @FXML
    private TableColumn<?, ?> productColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    public void initialize() {
        // Bind TableColumn to SalesRecord properties
        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        grossIncomeColumn.setCellValueFactory(new PropertyValueFactory<>("grossIncome"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("saleDate"));

        // Load sales data and set the TableView items
        ObservableList<SalesRecord> salesData = DBConnector.loadSalesData();
        SalesHistory.setItems(salesData);
    }

    @FXML
    void goToMain(ActionEvent event) throws IOException {
        new SceneSwitch(adminSalesPane, "mainFrame.fxml");
    }

    @FXML
    void goToStocks(ActionEvent event) throws IOException {
        new SceneSwitch(adminSalesPane, "adminManageStocks.fxml");
    }

}
