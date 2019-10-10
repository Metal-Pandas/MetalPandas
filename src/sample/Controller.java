package sample;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Controller {
  @FXML
  public Pane Backdrop;
  @FXML
  public Text Title;
  @FXML
  public Text Username;
  @FXML
  public TextField UsernameField;
  @FXML
  public Text Password;
  @FXML
  public TextField PasswordField;
  @FXML
  public Button loginButton;

  @FXML
  private BorderPane mainBorderPane;

  @FXML
  private void handleShowView1(ActionEvent e) {
    loadFXML(getClass().getResource("/sample/view_1.fxml"));
  }

  @FXML
  private void handleShowView2(ActionEvent e) {
    loadFXML(getClass().getResource("/sample/view_2.fxml"));
  }

  @FXML
  private void handleShowView3(ActionEvent e) {
    loadFXML(getClass().getResource("/sample/view_3.fxml"));
  }

  private void loadFXML(URL url) {
    try {
      FXMLLoader loader = new FXMLLoader(url);
      mainBorderPane.setCenter(loader.load());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
