package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class forgotEmailController {
  /*----------------------------------------------------------*/
  /* FORGOT EMAIL PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public AnchorPane forgotEmailPane;

  @FXML public TextField enterPhoneNumber;

  @FXML public Text phoneNumberInvalid;

  @FXML public Button confirmButton;

  @FXML public Button backButton;
  /*----------------------------------------------------------*/
  /* FORGOT EMAIL PAGE */
  /*----------------------------------------------------------*/
  public void handleConfirmButton(ActionEvent event) {
    phoneNumberInvalid.setText("Phone number is invalid.");
  }

  public void handleBackAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
