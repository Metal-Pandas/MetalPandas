package sample.Controllers;

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

public class forgotPasswordController {
  /*----------------------------------------------------------*/
  /* FORGOT PASSWORD PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public AnchorPane forgotPasswordPane;

  @FXML public TextField phoneNumberEnter;

  @FXML private Text forgotPasswordTxt;

  @FXML public Button confirmButton;

  @FXML public Button backButton;
  /*----------------------------------------------------------*/
  /* FORGOT PASSWORD PAGE */
  /*----------------------------------------------------------*/
  public void handleConfirmButton(ActionEvent event) {
    forgotPasswordTxt.setText("Email/Phone number is invalid.");
  }

  public void handleBackAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
