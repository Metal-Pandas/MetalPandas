package sample;

import java.io.IOException;
import java.net.URL;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
  public GridPane homePageBack;

  @FXML
  public BorderPane homePageBorderPane;


  @FXML
  public TabPane homeTab;

  @FXML
  public Tab MenuTab;

  @FXML
  public VBox drawer;

  @FXML
  public Button menuButton;

  @FXML
  public Button favouritesButton;

  @FXML
  public Button logoutButton;

  @FXML
  private void handleLoginAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  @FXML
  private void handleSignUpAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  @FXML
  private void handleMenuAction(ActionEvent event) {
    TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
    openNav.setToX(0);
    TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
    menuButton.setOnAction((ActionEvent evt) -> {
      if (drawer.getTranslateX() != 0) {
        openNav.play();
      } else {
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
      }
    });
  }

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
      homePageBorderPane.setCenter(loader.load());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}