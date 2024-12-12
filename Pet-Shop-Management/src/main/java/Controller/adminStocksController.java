package Controller;

import Implementation.DBConnector;
import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.EventObject;
import static Implementation.DBConnector.*;

public class adminStocksController {

    private String selectedValue;
    private MenuItem selectedItem;
    private int maxStockBreed = 20;
    private int maxStockPetFood = 30;
    private int maxStockAccessories = 50;

    private static EventObject event;
    @FXML
    private Label BirdFoodStock;

    @FXML
    private Label BirdStock;

    @FXML
    private Label CatCollarStock;

    @FXML
    private Label CatFoodStock;

    @FXML
    private Label CatLeashStock;

    @FXML
    private Label CatsStock;

    @FXML
    private Label DogCollarStock;

    @FXML
    private Label DogFoodStock;

    @FXML
    private Label DogLeashStock;

    @FXML
    private Label DogsStock;

    @FXML
    private MenuButton MenuBirdFood;

    @FXML
    private MenuButton MenuBirds;

    @FXML
    private MenuButton MenuCatCollar;

    @FXML
    private MenuButton MenuCatFood;

    @FXML
    private MenuButton MenuCatLeash;

    @FXML
    private MenuButton MenuCats;

    @FXML
    private MenuButton MenuDogCollar;

    @FXML
    private MenuButton MenuDogFood;

    @FXML
    private MenuButton MenuDogLeash;

    @FXML
    private MenuButton MenuDogs;

    @FXML
    private TextField TxtBirdFoodStock;

    @FXML
    private TextField TxtBirdStock;

    @FXML
    private TextField TxtCatCollarStock;

    @FXML
    private TextField TxtCatFoodStock;

    @FXML
    private TextField TxtCatLeashStock;

    @FXML
    private TextField TxtCatStock;

    @FXML
    private TextField TxtDogCollarStock;

    @FXML
    private TextField TxtDogFoodStock;

    @FXML
    private TextField TxtDogLeashStock;

    @FXML
    private TextField TxtDogStock;


    @FXML
    private AnchorPane manageStocksPane;

    public void initialize() {
        setupMenu(MenuBirdFood);
        setupMenu(MenuBirds);
        setupMenu(MenuCatCollar);
        setupMenu(MenuCatFood);
        setupMenu(MenuCatLeash);
        setupMenu(MenuCats);
        setupMenu(MenuDogCollar);
        setupMenu(MenuDogFood);
        setupMenu(MenuDogLeash);
        setupMenu(MenuDogs);
    }
    private void handleMenuAction(ActionEvent event) {

        selectedItem = (MenuItem) event.getSource();
        selectedValue = selectedItem.getText();
        //birds
        viewStockAnimals("Parakeet", BirdStock);
        viewStockAnimals("Canary", BirdStock);
        viewStockAnimals("Macaw", BirdStock);

        //dogs
        viewStockAnimals("Golden Retriever", DogsStock);
        viewStockAnimals("Chihuahua", DogsStock);
        viewStockAnimals("Chow Chow", DogsStock);

        //cats
        viewStockAnimals("Scottish Fold", CatsStock);
        viewStockAnimals("British Long Hair", CatsStock);
        viewStockAnimals("Sokoke", CatsStock);

        //bird food
        viewStockPetFood("VitaCraft", BirdFoodStock);
        viewStockPetFood("Kaytee", BirdFoodStock);
        viewStockPetFood("Nut N' Berry", BirdFoodStock);

        //dog food
        viewStockPetFood("Pedigree", DogFoodStock);
        viewStockPetFood("Kibble n' Bits", DogFoodStock);
        viewStockPetFood("Boss Dogs", DogFoodStock);

        //cat food
        viewStockPetFood("Goodest", CatFoodStock);
        viewStockPetFood("Whiskas", CatFoodStock);
        viewStockPetFood("Pro Plan", CatFoodStock);

        //accessories dog
        viewStockAccessories("Dog Collar(S)", DogCollarStock);
        viewStockAccessories("Dog Collar(M)", DogCollarStock);
        viewStockAccessories("Dog Collar(L)", DogCollarStock);

        viewStockAccessories("Dog Leash(S)", DogLeashStock);
        viewStockAccessories("Dog Leash(M)", DogLeashStock);
        viewStockAccessories("Dog Leash(L)", DogLeashStock);

        //accessories cat
        viewStockAccessories("Cat Collar(S)", CatCollarStock);
        viewStockAccessories("Cat Collar(M)", CatCollarStock);
        viewStockAccessories("Cat Collar(L)", CatCollarStock);

        viewStockAccessories("Cat Leash(S)", CatLeashStock);
        viewStockAccessories("Cat Leash(M)", CatLeashStock);
        viewStockAccessories("Cat Leash(L)", CatLeashStock);

    }
    @FXML
    void goToMain(ActionEvent event) throws IOException {
        new SceneSwitch(manageStocksPane, "mainFrame.fxml",true);
    }

    @FXML
    void goToSales(ActionEvent event) throws IOException {
        new SceneSwitch(manageStocksPane,"adminSales.fxml",true);
    }

    @FXML
    void goToStocks(ActionEvent event) {

    }
    @FXML
    void AddStockBirds(ActionEvent event) {

        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }

        int num = Integer.parseInt(TxtBirdStock.getText());

        if (selectedValue.equals("Parakeet")) {
            String productName = "Parakeet";
            String birdStock = String.valueOf(DBConnector.getStockByBreedName("Parakeet") + num);
            int birdie = DBConnector.getStockByBreedName("Parakeet") + num;
            if(birdie<= maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> BirdStock.setText(birdStock));
                TxtBirdStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdStock.setText("");
        }

        else if (selectedValue.equals("Canary")) {
            String productName = "Canary";
            String birdStock = String.valueOf(DBConnector.getStockByBreedName("Canary") + num);
            int birdie = DBConnector.getStockByBreedName("Canary") + num;
            if(birdie<= maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> BirdStock.setText(birdStock));
                TxtBirdStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdStock.setText("");
        }

        else if (selectedValue.equals("Macaw")) {
            String productName = "Macaw";
            String birdStock = String.valueOf(DBConnector.getStockByBreedName("Macaw") + num);
            int birdie = DBConnector.getStockByBreedName("Macaw") + num;
            if (birdie <= maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> BirdStock.setText(birdStock));
                TxtBirdStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdStock.setText("");
        }
    }

    @FXML
    void AddStockCats(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtCatStock.getText());


        if (selectedValue.equals("Scottish Fold")) {
            String productName = "Scottish Fold";
            String catStock = String.valueOf(DBConnector.getStockByBreedName("Scottish Fold") + num);
            int kitty = DBConnector.getStockByBreedName("Scottish Fold")+ num;
            if(kitty < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> CatsStock.setText(catStock));
                TxtCatStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatStock.setText("");
        }
        else if (selectedValue.equals("British Long Hair")) {
            String productName = "British Long Hair";
            String catStock = String.valueOf(DBConnector.getStockByBreedName("British Long Hair") + num);
            int kitty = DBConnector.getStockByBreedName("British Long Hair")+ num;
            if(kitty < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> CatsStock.setText(catStock));
                TxtCatStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatStock.setText("");
        }
        else if (selectedValue.equals("Sokoke")) {
            String productName = "Sokoke";
            String catStock = String.valueOf(DBConnector.getStockByBreedName(" Sokoke") + num);
            int kitty = DBConnector.getStockByBreedName("Sokoke") + num;
            if (kitty < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> CatsStock.setText(catStock));
                TxtCatStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatStock.setText("");
        }
    }
    @FXML
    void AddStockDogs(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }

        int num = Integer.parseInt(TxtDogStock.getText());

        if (selectedValue.equals("Golden Retriever")) {
            String productName = "Golden Retriever";
            String dogStock = String.valueOf(DBConnector.getStockByBreedName("Golden Retriever") + num);
            int doggie = DBConnector.getStockByBreedName("Golden Retriever") + num;
            if(doggie < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> DogsStock.setText(dogStock));
                TxtDogStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogStock.setText("");
        }

        else if (selectedValue.equals("Chihuahua")) {
            String productName = "Chihuahua";
            String dogStock = String.valueOf(DBConnector.getStockByBreedName("Chihuahua") + num);
            int doggie = DBConnector.getStockByBreedName("Chihuahua") + num;
            if(doggie < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> DogsStock.setText(dogStock));
                TxtDogStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogStock.setText("");
        }

        else if (selectedValue.equals("Chow Chow")) {
            String productName = "Chow Chow";
            String dogStock = String.valueOf(DBConnector.getStockByBreedName("Chow Chow") + num);
            int doggie = DBConnector.getStockByBreedName("Chow Chow") + num;
            if(doggie < maxStockBreed) {
                AddStockByBreedName(productName, num);
                Platform.runLater(() -> DogsStock.setText(dogStock));
                TxtDogStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogStock.setText("");
        }


    }

    @FXML
    void AddStockCatFood(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtCatFoodStock.getText());

        if (selectedValue.equals("Goodest")) {
            String productName = "Goodest";
            String catfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Goodest") + num);
            int food = DBConnector.getStockByPetFoodName("Goodest") + num;
            if (food < maxStockPetFood) {
                Platform.runLater(() -> CatFoodStock.setText(catfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtCatFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatFoodStock.setText("");
        }

        else if (selectedValue.equals("Whiskas")) {
            String productName = "Whiskas";
            String catfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Whiskas") + num);
            int food = DBConnector.getStockByPetFoodName("Whiskas") + num;
            if (food < maxStockPetFood) {
                Platform.runLater(() -> CatFoodStock.setText(catfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtCatFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatFoodStock.setText("");
        }

        else if (selectedValue.equals("Pro Plan")) {
            String productName = "Pro Plan";
            String catfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Pro Plan") + num);
            int food = DBConnector.getStockByPetFoodName("Whiskas") + num;
            if (food < maxStockPetFood) {
                Platform.runLater(() -> CatFoodStock.setText(catfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtCatFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatFoodStock.setText("");
}
    }
    @FXML
    void AddStockBirdFood(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtBirdFoodStock.getText());

        if (selectedValue.equals("VitaCraft")) {
            String productName = "VitaCraft";
            String birdfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("VitaCraft") + num);
            int food = DBConnector.getStockByPetFoodName("VitaCraft") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> BirdFoodStock.setText(birdfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtBirdFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdFoodStock.setText("");
        }

        else if (selectedValue.equals("Kaytee")) {
            String productName = "Kaytee";
            String birdfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Kaytee") + num);
            int food = DBConnector.getStockByPetFoodName("Kaytee") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> BirdFoodStock.setText(birdfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtBirdFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdFoodStock.setText("");
        }

        else if (selectedValue.equals("Nut N' Berry")) {
            String productName = "Nut N' Berry";
            String birdfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Nut N' Berry") + num);
            int food = DBConnector.getStockByPetFoodName("Nut N' Berry") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> BirdFoodStock.setText(birdfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtBirdFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtBirdFoodStock.setText("");
        }
    }
    @FXML
    void AddStockDogFood(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtDogFoodStock.getText());

        if (selectedValue.equals("Pedigree")) {
            String productName = "Pedigree";
            String dogfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Pedigree") + num);
            int food = DBConnector.getStockByPetFoodName("Pedigree") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> DogFoodStock.setText(dogfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtDogFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogFoodStock.setText("");
        }

        else if (selectedValue.equals("Kibble n' Bits")) {
            String productName = "Kibble n' Bits";
            String dogfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Kibble n' Bits") + num);
            int food = DBConnector.getStockByPetFoodName("Kibble n' Bits") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> DogFoodStock.setText(dogfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtDogFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogFoodStock.setText("");
        }

        else if (selectedValue.equals("Boss Dogs")) {
            String productName = "Boss Dogs";
            String dogfoodStock = String.valueOf(DBConnector.getStockByPetFoodName("Boss Dogs") + num);
            int food = DBConnector.getStockByPetFoodName("Boss Dogs") + num;
            if(food < maxStockPetFood) {
                Platform.runLater(() -> DogFoodStock.setText(dogfoodStock));
                AddStockByPetFoodName(productName, num);
                TxtDogFoodStock.setText("");
            }
            else{
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogFoodStock.setText("");
        }
    }

    @FXML
    void AddStockDogCollar(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }

        int num = Integer.parseInt(TxtDogCollarStock.getText());

        if (selectedValue.equals("Dog Collar(S)")) {
            String productName = "Dog Collar(S)";
            String dogcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Collar(S)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Dog Collar(S)") + num;
            if(collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogCollarStock.setText(dogcollarStock));
                TxtDogCollarStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogCollarStock.setText("");
        }

        else if (selectedValue.equals("Dog Collar(M)")) {
            String productName = "Dog Collar(M)";
            String dogcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Collar(M)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Dog Collar(M)") + num;
            if(collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogCollarStock.setText(dogcollarStock));
                TxtDogCollarStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogCollarStock.setText("");
        }

        else if (selectedValue.equals("Dog Collar(L)")) {
            String productName = "Dog Collar(L)";
            String dogcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Collar(L)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Dog Collar(L)") + num;
            if(collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogCollarStock.setText(dogcollarStock));
                TxtDogCollarStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogCollarStock.setText("");
        }
    }

    @FXML
    void AddStockDogLeash(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtDogLeashStock.getText());

        if (selectedValue.equals("Dog Leash(S)")) {
            String productName = "Dog Leash(S)";
            String dogleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Leash(S)") + num);
            int leash = DBConnector.getStockByAccessoriesName("Dog Leash(S)") + num;
            if(leash < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogLeashStock.setText(dogleashStock));
                TxtDogLeashStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogLeashStock.setText("");
        }
        else if (selectedValue.equals("Dog Leash(M)")) {
            String productName = "Dog Leash(M)";
            String dogleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Leash(M)") + num);
            int leash = DBConnector.getStockByAccessoriesName("Dog Leash(M)") + num;
            if(leash < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogLeashStock.setText(dogleashStock));
                TxtDogLeashStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogLeashStock.setText("");
        }
        else if (selectedValue.equals("Dog Leash(L)")) {
            String productName = "Dog Leash(L)";
            String dogleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Dog Leash(L)") + num);
            int leash = DBConnector.getStockByAccessoriesName("Dog Leash(L)") + num;
            if(leash < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> DogLeashStock.setText(dogleashStock));
                TxtDogLeashStock.setText("");
            }
            else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtDogLeashStock.setText("");
        }
    }
    @FXML
    void AddStockCatCollar(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtCatCollarStock.getText());

        if (selectedValue.equals("Cat Collar(S)")) {
            String productName = "Cat Collar(S)";
            String catcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Collar(S)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(S)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatCollarStock.setText(catcollarStock));
                TxtCatCollarStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatCollarStock.setText("");
        }

        else if (selectedValue.equals("Cat Collar(M)")) {
            String productName = "Cat Collar(M)";
            String catcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Collar(M)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(M)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatCollarStock.setText(catcollarStock));
                TxtCatCollarStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatCollarStock.setText("");
        }
        else if (selectedValue.equals("Cat Collar(L)")) {
            String productName = "Cat Collar(L)";
            String catcollarStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Collar(L)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(L)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatCollarStock.setText(catcollarStock));
                TxtCatCollarStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatCollarStock.setText("");
        }
    }
    @FXML
    void AddStockCatLeash(ActionEvent event) {
        if (event.getSource() instanceof MenuItem) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            selectedValue = selectedItem.getText();
        } else if (event.getSource() instanceof Button) {
            Button selectedButton = (Button) event.getSource();

        }


        int num = Integer.parseInt(TxtCatLeashStock.getText());

        if (selectedValue.equals("Cat Leash(S)")) {
            String productName = "Cat Leash(S)";
            String catleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Leash(S)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(S)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatLeashStock.setText(catleashStock));
                TxtCatLeashStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatLeashStock.setText("");
        }

        else if (selectedValue.equals("Cat Leash(M)")) {
            String productName = "Cat Leash(M)";
            String catleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Leash(M)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(M)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatLeashStock.setText(catleashStock));
                TxtCatLeashStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatLeashStock.setText("");
        }

        else if (selectedValue.equals("Cat Leash(L)")) {
            String productName = "Cat Leash(L)";
            String catleashStock = String.valueOf(DBConnector.getStockByAccessoriesName("Cat Leash(L)") + num);
            int collar = DBConnector.getStockByAccessoriesName("Cat Collar(L)") + num;
            if (collar < maxStockAccessories) {
                AddStockByAccessoriesName(productName, num);
                Platform.runLater(() -> CatLeashStock.setText(catleashStock));
                TxtCatLeashStock.setText("");
            } else {
                showAlert("Max Stock Limit Reached", "The requested stock exceeds the maximum allowed quantity.");
            }
            TxtCatLeashStock.setText("");
        }
    }

    private void setupMenu(MenuButton menuButton) {
        for (MenuItem menuItem : menuButton.getItems()) {
            menuItem.setOnAction(this::handleMenuAction);
        }
    }

    private void viewStockAnimals(String breed, Label stock) {
        if (selectedValue.equals(breed)) {
            String Sstock = String.valueOf(DBConnector.getStockByBreedName(breed));
            if(breed.equals("Parakeet") ||breed.equals("Canary") || breed.equals("Macaw")) {
                Platform.runLater(() -> MenuBirds.setText(breed));
                Platform.runLater(() -> stock.setText(Sstock));
            }

            else if (breed.equals("Golden Retriever") ||breed.equals("Chihuahua") || breed.equals("Chow Chow")) {
                Platform.runLater(() -> MenuDogs.setText(breed));
                Platform.runLater(() -> stock.setText(Sstock));
            }
            else if(breed.equals("Scottish Fold") ||breed.equals("British Long Hair") || breed.equals("Sokoke")) {
                Platform.runLater(() -> MenuCats.setText(breed));
                Platform.runLater(() -> stock.setText(Sstock));
            }
        }

    }

    private void viewStockPetFood(String PetFood, Label stock) {
        if (selectedValue.equals(PetFood)) {
            String Sstock = String.valueOf(DBConnector.getStockByPetFoodName(PetFood));
            if(PetFood.equals("VitaCraft") ||PetFood.equals("Kaytee") || PetFood.equals("Nut N' Berry")) {
                Platform.runLater(() -> MenuBirdFood.setText(PetFood));
                Platform.runLater(() -> stock.setText(Sstock));
            }
            else if(PetFood.equals("Boss Dogs") ||PetFood.equals("Kibble n' Bits") || PetFood.equals("Pedigree")) {
                Platform.runLater(() -> MenuDogFood.setText(PetFood));
                Platform.runLater(() -> stock.setText(Sstock));
            }
            else if(PetFood.equals("Pro Plan") ||PetFood.equals("Whiskas") || PetFood.equals("Goodest")) {
                Platform.runLater(() -> MenuCatFood.setText(PetFood));
                Platform.runLater(() -> stock.setText(Sstock));
            }
        }

    }
    private void viewStockAccessories(String Accessories, Label stock) {
        if (selectedValue.equals(Accessories)) {
            String Sstock = String.valueOf(DBConnector.getStockByAccessoriesName(Accessories));
            if (Accessories.equals("Dog Collar(S)") || Accessories.equals("Dog Collar(M)") || Accessories.equals("Dog Collar(L)")) {
                Platform.runLater(() -> MenuDogCollar.setText(Accessories));
                Platform.runLater(() -> stock.setText(Sstock));
            }
            else if (Accessories.equals("Dog Leash(S)") || Accessories.equals("Dog Leash(M)") || Accessories.equals("Dog Leash(L)")) {
                Platform.runLater(() -> MenuDogLeash.setText(Accessories));
                Platform.runLater(() -> stock.setText(Sstock));
            }
            else if (Accessories.equals("Cat Collar(S)") || Accessories.equals("Cat Collar(M)") || Accessories.equals("Cat Collar(L)")) {
                Platform.runLater(() -> MenuCatCollar.setText(Accessories));
                Platform.runLater(() -> stock.setText(Sstock));
        }
            else if (Accessories.equals("Cat Leash(S)") || Accessories.equals("Cat Leash(M)") || Accessories.equals("Cat Leash(L)")) {
                Platform.runLater(() -> MenuCatLeash.setText(Accessories));
                Platform.runLater(() -> stock.setText(Sstock));
    }
}
}
    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); // Information type alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(message);
        alert.showAndWait(); // Show the alert and wait for user acknowledgment
    }
}
