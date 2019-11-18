package MetalPandasCarApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class PandaProfileRating {

  @FXML public Pane profileRatingBackground;
  //@FXML public Rating starRating;
  @FXML public Label ratingLabelTitle;
  @FXML public Label ratingLabel;
  @FXML public Button confirmRating;
  @FXML public Circle rating1;
  @FXML public Circle rating2;
  @FXML public Circle rating3;
  @FXML public Circle rating4;
  @FXML public Circle rating5;


  public void handleRateAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkAppointments.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleRating1Action(MouseEvent mouseEvent) {
    rating1.setFill(javafx.scene.paint.Color.YELLOW);
    rating2.setFill(Color.TRANSPARENT);
    rating3.setFill(Color.TRANSPARENT);
    rating4.setFill(Color.TRANSPARENT);
    rating5.setFill(Color.TRANSPARENT);
  }

  public void handleRating2Action(MouseEvent mouseEvent) {
    rating1.setFill(javafx.scene.paint.Color.YELLOW);
    rating2.setFill(javafx.scene.paint.Color.YELLOW);
    rating3.setFill(Color.TRANSPARENT);
    rating4.setFill(Color.TRANSPARENT);
    rating5.setFill(Color.TRANSPARENT);
  }

  public void handleRating3Action(MouseEvent mouseEvent) {
    rating1.setFill(javafx.scene.paint.Color.YELLOW);
    rating2.setFill(javafx.scene.paint.Color.YELLOW);
    rating3.setFill(javafx.scene.paint.Color.YELLOW);
    rating4.setFill(Color.TRANSPARENT);
    rating5.setFill(Color.TRANSPARENT);
  }

  public void handleRating4Action(MouseEvent mouseEvent) {
    rating1.setFill(javafx.scene.paint.Color.YELLOW);
    rating2.setFill(javafx.scene.paint.Color.YELLOW);
    rating3.setFill(javafx.scene.paint.Color.YELLOW);
    rating4.setFill(javafx.scene.paint.Color.YELLOW);
    rating5.setFill(Color.TRANSPARENT);
  }

  public void handleRating5Action(MouseEvent mouseEvent) {
    rating1.setFill(javafx.scene.paint.Color.YELLOW);
    rating2.setFill(javafx.scene.paint.Color.YELLOW);
    rating3.setFill(javafx.scene.paint.Color.YELLOW);
    rating4.setFill(javafx.scene.paint.Color.YELLOW);
    rating5.setFill(javafx.scene.paint.Color.YELLOW);
  }
}
