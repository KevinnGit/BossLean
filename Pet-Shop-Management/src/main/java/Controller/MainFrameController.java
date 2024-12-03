package Controller;

import finalprjct.petshopmanagementsystem.SceneSwitch;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFrameController implements Initializable {

    @FXML
    private StackPane ImageSlider;

    @FXML
    private ImageView Next;

    @FXML
    private ImageView Previous;

    @FXML
    private AnchorPane dog1;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private AnchorPane dog2;

    @FXML
    private AnchorPane dog3;
    int click = 0;
    int preclick = 3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    dog2.setVisible(false);
    dog3.setVisible(false);

    }

    @FXML
    void goToCart(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "CartFrame.fxml");
    }

    @FXML
    void goToAccessories(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "AccessoriesFrame.fxml");
    }

    @FXML
    void goToFood(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "PetFoodFrame.fxml");
    }

    @FXML
    void goToGroomings(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "GroomingFrame.fxml");
    }

    @FXML
    void goToPets(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "PetFrame.fxml");

        }

    @FXML
    void goToAdmin(ActionEvent event) throws IOException {
        new SceneSwitch(mainFrame, "adminMenu.fxml");
    }


    @FXML
    void NextPicture(ActionEvent event) {
        click++;
        if (click >= preclick) {
            click = 0;
        }


        if (click == 0) {
            dog3.setVisible(false);
            dog1.setVisible(true);
            dog1.translateXProperty().set(ImageSlider.getWidth() + 310);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog1.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();

        } else if (click == 1) {
            dog1.setVisible(false);
            dog2.setVisible(true);
            dog2.translateXProperty().set(ImageSlider.getWidth() + 310);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog2.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        } else if (click == 2) {
            dog1.setVisible(false);
            dog2.setVisible(false);
            dog3.setVisible(true);
            dog3.translateXProperty().set(ImageSlider.getWidth() + 310);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog3.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        }
    }


    @FXML
    void PreviousPicture(ActionEvent event) {

        click--;
        if (click < 0) {
            click = preclick - 1;
        }


        if (click == 0) {
            dog3.setVisible(false);
            dog2.setVisible(false);
            dog1.setVisible(true);
            dog1.translateXProperty().set(-ImageSlider.getWidth() - 250);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog1.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        } else if (click == 1) {
            dog1.setVisible(false);
            dog3.setVisible(false);
            dog2.setVisible(true);
            dog2.translateXProperty().set(-ImageSlider.getWidth() - 250);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog2.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        } else if (click == 2) {
            dog1.setVisible(false);
            dog2.setVisible(false);
            dog3.setVisible(true);
            dog3.translateXProperty().set(-ImageSlider.getWidth() - 250);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(dog3.translateXProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(1.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        }
    }
}



