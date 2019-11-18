package MetalPandasCarApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PandaForgotPassword {
  @FXML public AnchorPane forgotPasswordBackground;
  @FXML public Label forgotPassLabel;
  @FXML public TextField forgotPasswordPhoneNumber;
  @FXML public Button passwordConfirm;
  @FXML public Label forgotPassStatus;
  @FXML public Label orLabel;
  @FXML public Label forgotPasswordLabel;
  @FXML public TextField forgotPasswordEmail;
  @FXML public Button passConfirm;
  @FXML public Label forgotPasswordStatus;
  @FXML public Button passBack;


  public void handleConfirmAction(ActionEvent actionEvent) throws IOException {
    if(forgotPasswordEmail.getText().equals("jsmith@abc.com")) {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaReset.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }

    if(!forgotPasswordEmail.getText().equals("jsmith@abc.com")){
      forgotPasswordStatus.setText("Invalid Email Address!");
    }
  }

  public void handlePasswordConfirmAction(ActionEvent actionEvent) throws IOException{
    if(forgotPasswordPhoneNumber.getText().equals("1234567890")){
      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaReset.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }

    if(!forgotPasswordPhoneNumber.getText().equals("1234567890")){
      forgotPassStatus.setText("Invalid Phone Number!");
    }
  }

  public void handleBackAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
