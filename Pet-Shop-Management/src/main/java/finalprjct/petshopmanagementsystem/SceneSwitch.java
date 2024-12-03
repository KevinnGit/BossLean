package finalprjct.petshopmanagementsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class SceneSwitch {

    private static Stack<String> sceneHistory = new Stack<>(); // Stack to store the scene history

    // Constructor to load the scene and switch the current scene
    public SceneSwitch(AnchorPane rootPane, String fxml, boolean maximize) throws IOException {
        // Before loading the new scene, ensure that we're not pushing the same scene multiple times
        if (sceneHistory.isEmpty() || !sceneHistory.peek().equals(fxml)) {
            sceneHistory.push(fxml); // Push the current scene to the history before switching
        }

        // Load the new scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent newScene = loader.load();

        // Switch the scene on the current stage
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setScene(new Scene(newScene));
        stage.show();

        // Maximize the window based on the condition
        if (maximize && shouldMaximize(fxml)) {
            stage.setMaximized(true); // Maximize the window if condition is true
        }
    }

    // Method to determine if a scene should be maximized
    private boolean shouldMaximize(String fxml) {
        // List of scenes that should be maximized
        // You can modify this list based on your requirements
        String[] scenesToMaximize = {"adminMenu.fxml", "mainFrame.fxml"};

        // Check if the current scene is in the list of scenes that should be maximized
        for (String scene : scenesToMaximize) {
            if (scene.equals(fxml)) {
                return true;
            }
        }
        return false; // Default to not maximizing
    }

    // Method to go back to the previous scene
    public static void goBackToPreviousScene(AnchorPane rootPane) throws IOException {
        if (!sceneHistory.isEmpty()) {
            // Remove the current scene from the history to get the previous one
            sceneHistory.pop();

            // Check if the previous scene is CustomerFrame, and if so, go to the previous-previous scene
            if (!sceneHistory.isEmpty() && sceneHistory.peek().equals("CustomerFrame.fxml")) {
                // Pop twice to get the scene before CustomerFrame
                sceneHistory.pop();

                if (!sceneHistory.isEmpty()) {
                    String previousPreviousScene = sceneHistory.peek();
                    new SceneSwitch(rootPane, previousPreviousScene, true);  // Go to the previous-previous scene
                } else {
                    // If no previous scene exists, default to mainFrame
                    new SceneSwitch(rootPane, "mainFrame.fxml", true);
                }
            } else if (!sceneHistory.isEmpty()) {
                // If it's not CustomerFrame, just go to the previous scene
                String previous = sceneHistory.peek();
                new SceneSwitch(rootPane, previous, true);
            } else {
                // Default to mainFrame.fxml if no previous scene exists
                new SceneSwitch(rootPane, "mainFrame.fxml", true);
            }
        }
    }

    // Getter for the current scene (optional)
    public static String getCurrentScene() {
        return sceneHistory.isEmpty() ? null : sceneHistory.peek();
    }
}
