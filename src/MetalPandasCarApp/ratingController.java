package MetalPandasCarApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ratingController {

  @FXML
  public Rating starRating;

  @FXML
  public Label starRatingLabel;

  @FXML
  public Pane profileRatingBack;

  public void initialize(URL arg0, ResourceBundle arg1) {
    try{
    starRating.ratingProperty().addListener(new ChangeListener<Number>() {
              @Override
              public void changed(ObservableValue<? extends Number> arg0, Number t, Number t1) {
                starRatingLabel.setText("Rating: " + t1.toString());
              }
    });
    } catch (java.lang.NullPointerException exception) {
      exception.printStackTrace();
    }
  }


  public void handleConfirmRatingAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}






