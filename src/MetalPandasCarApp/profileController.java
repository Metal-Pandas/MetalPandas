package MetalPandasCarApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class profileController {
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

  @FXML public ToggleButton darkMode;

  @FXML public ToggleButton lightMode;

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

  private static String updateSQL;
  private static Connection conn;

  /*----------------------------------------------------------*/
  /* PROFILE PAGE */
  /*----------------------------------------------------------*/
  public void handleMenuAction(ActionEvent event) {
    part1Menu.setVisible(true);
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

  public void handleUpdateAction(ActionEvent event) throws IOException, SQLException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("editPage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();

    /** ODALYS START CODE **/
    updateProfile();

    /** ODALYS END CODE **/
  }
/** ODALYS START CODE **/
  public void updateProfile() throws SQLException {
    String FirstName = profileFName.getText();
    String LastName = profileLName.getText();
    String Email = proEmail.getText();
    String Address = profAddress.getText();
    String PickCountry = countryCombo.getText();
    String PhoneNum = profNumber.getText();
    String Birthday = profBirthday.getText();
    String Mode = modeBox.getText();
    String[] updateUser = {
            FirstName, LastName, Email, Address, PickCountry, PhoneNum, Birthday, Mode
    };

    DatabaseDriver.updateUserInDB(updateUser);
  }

  public void initialize() {
    try {
    } catch (java.lang.NullPointerException exception) {
      exception.printStackTrace();
    }

    // Calls the Database
    DatabaseDriver.initializeDB();
  }

/** ODALYS END CODE **/

  public void handleHomeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("favourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLogoutAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleDarkModeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
    }

  public void handleLightModeAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("lightProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}
