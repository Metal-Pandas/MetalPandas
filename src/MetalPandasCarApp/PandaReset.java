package MetalPandasCarApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PandaReset {
  @FXML public AnchorPane resetBackground;
  @FXML public Button confirmButton;
  @FXML public PasswordField password;
  @FXML public PasswordField reenterPassword;
  @FXML public Text resetPasswordLabel;
  @FXML public Text passwordCheckText;

  public void handleConfirmAction(ActionEvent actionEvent) throws IOException{
    if (password.getText().equals("")){
      passwordCheckText.setText("please enter a new Password");
    }
    else if (password.getText().equals(reenterPassword.getText())) {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    }
    else if(!password.getText().equals(reenterPassword.getText())){
      passwordCheckText.setText("Passwords do not match.");
    }
  }

  public void handlePopupAction(MouseEvent mouseEvent) throws IOException {
    if (password.getText().equals(reenterPassword.getText())) {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaResetPasswordPopup.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
      }
  }
}
