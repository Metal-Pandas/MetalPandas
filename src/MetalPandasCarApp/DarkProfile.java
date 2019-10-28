package MetalPandasCarApp;

import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DarkProfile extends Main {
  /*----------------------------------------------------------*/
  /* PROFILE PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public SplitPane profileSplit;

  @FXML public Pane profileBackdrop;

  @FXML public Text profileFirst;

  @FXML public Text profileLast;

  @FXML public Text profileEmail;

  @FXML public Text profileNumber;

  @FXML public Text profileBirthday;

  @FXML public Text profileAddress;

  @FXML public Text profileCountry;

  @FXML public Text profileMode;

  @FXML public TextField profileFName;

  @FXML public TextField profileLName;

  @FXML public TextField proEmail;

  @FXML public TextField profNumber;

  @FXML public TextField profBirthday;

  @FXML public TextField profAddress;

  @FXML public TextField countryCombo;

  @FXML public TextField modeBox;

  @FXML public Button update;

  @FXML public GridPane homePageBack;

  @FXML public VBox setUp;

  @FXML public ToolBar topToolBar;

  @FXML public Button menuButton;

  @FXML public ToggleButton lightMode;

  @FXML public ToggleButton pandaMode;

  @FXML public StackPane stackPane;

  @FXML public HBox part1Menu;

  @FXML public VBox drawer;

  @FXML public GridPane imageGrid;

  @FXML public ImageView signProfilePic;

  @FXML public BorderPane buttonMenu;

  @FXML public Button profileButton;

  @FXML public Button favouritesButton;

  @FXML public BorderPane logOutBorderPane;

  @FXML public Button logoutButton;
  /*----------------------------------------------------------*/
  /* PROFILE PAGE */
  /*----------------------------------------------------------*/
  public void handleMenuAction(ActionEvent event) {
    darkTheme = true;
    TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
    openNav.setToX(0);
    TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
    menuButton.setOnAction(
        (ActionEvent evt) -> {
          if (drawer.getTranslateX() != 0) {
            openNav.play();
          } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
          }
        });
  }

  public void handleUpdateAction(ActionEvent event) throws IOException {
    darkTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkEdit.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleHomeAction(ActionEvent event) throws IOException {
    darkTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkHome.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavAction(ActionEvent event) throws IOException {
    darkTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkFavourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLogoutAction(ActionEvent event) throws IOException {
    darkTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLightModeAction(ActionEvent event) throws IOException {
    lightTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handlePandaModeAction(ActionEvent event) throws IOException {
    pandaTheme = true;
    Parent homePageParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
