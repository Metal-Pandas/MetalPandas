package MetalPandasCarApp;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PandaHome {
  /*----------------------------------------------------------*/
  /* HOME PAGE ITEMS */
  /*----------------------------------------------------------*/
  @FXML public GridPane homePageBack;

  @FXML public SplitPane homePageSplitPane;

  @FXML public VBox setUp;

  @FXML public ToolBar topToolBar;

  @FXML public Button menuButton;

  @FXML public StackPane stackPane;

  @FXML public WebView maps;

  @FXML public HBox part1Menu;

  @FXML public VBox drawer;

  @FXML public GridPane imageGrid;

  @FXML public ImageView signProfilePic;

  @FXML public BorderPane buttonMenu;

  @FXML public Button profileButton;

  @FXML public Button favouritesButton;

  @FXML public BorderPane logOutBorderPane;

  @FXML public Button logoutButton;

  @FXML public Button sendMyRideButton;

  @FXML public ChoiceBox<String> hourChoiceBox;

  @FXML public ChoiceBox<Integer> minuteChoiceBox;

  @FXML public ChoiceBox<String> amPmChoiceBox;

  @FXML public Label selectDateTF;

  @FXML public Label selectTimeTF;

  /*----------------------------------------------------------*/
  /* HOME PAGE */
  /*----------------------------------------------------------*/
  public void initialize() {
    WebEngine engine = maps.getEngine();
    engine.load("https://www.google.com/maps/");

    try {
      hourChoiceBox.setItems(
          FXCollections.observableArrayList(
              "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
      minuteChoiceBox.setItems(
          FXCollections.observableArrayList(
              00, 01, 02, 03, 04, 05, 06, 07, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
              23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
              44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59));
      amPmChoiceBox.setItems(FXCollections.observableArrayList("am", "pm"));
    } catch (java.lang.NullPointerException exception) {
      exception.printStackTrace();
    }
  }

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

  public void handleProfileAction(ActionEvent event) throws IOException {
    // Calls the Database
    DatabaseDriver.initializeDB();

    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaFavourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleLogoutAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleSendMyRideAction(ActionEvent event) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaProfileRating.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }
}

