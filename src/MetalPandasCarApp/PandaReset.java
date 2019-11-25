package MetalPandasCarApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PandaReset {
  @FXML public AnchorPane resetBackground;
  @FXML public Button confirmButton;
  @FXML public PasswordField password;
  @FXML public PasswordField reenterPassword;
  @FXML public Text resetPasswordLabel;

  public void handleConfirmAction(ActionEvent actionEvent) throws IOException{
    if (password.getText().equals("")){
      Alert confirmPopUp = new Alert(Alert.AlertType.NONE);
      confirmPopUp.setAlertType(AlertType.WARNING);
      confirmPopUp.setContentText("Please enter a new Password.");
      confirmPopUp.show();
    }

    else if (password.getText().equals(reenterPassword.getText())) {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();

      Alert confirmPopUp = new Alert(Alert.AlertType.NONE);
      confirmPopUp.setAlertType(AlertType.INFORMATION);
      confirmPopUp.setContentText("Password has been changed! Thank you!");
      confirmPopUp.show();
    }

    else if(!password.getText().equals(reenterPassword.getText())){
      Alert confirmPopUp = new Alert(Alert.AlertType.NONE);
      confirmPopUp.setAlertType(AlertType.WARNING);
      confirmPopUp.setContentText("Passwords do not match.");
      confirmPopUp.show();
    }
  }
}
