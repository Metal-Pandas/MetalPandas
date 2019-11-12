package MetalPandasCarApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.Action;

public class ResetPasswordController {
  /*----------------------------------------------------------*/
  /* RESET PASSWORD PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public Text verifiText;
  @FXML public TextField verifiNum;
  @FXML public Button verifyButton;
  @FXML public Button resetPassBackButton;
  /*----------------------------------------------------------*/
  /* RESET PASSWORD PAGE */
  /*----------------------------------------------------------*/
  public void handleVerifyButton(ActionEvent verifyEvent) {
    if(verifiNum.getText().equals("123456")){
      verifiText.setText("Password Has been reset to: Password1");



    }
    if(!verifiNum.getText().equals("123456")){
      verifiText.setText("Incorrect Verification Number");




    }
  }
public void handleResetPassBackButton(ActionEvent event) throws IOException {
  Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
  Scene homePageScene = new Scene(homePageParent);
  Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
  homeStage.setScene(homePageScene);
  homeStage.show();
}
}
