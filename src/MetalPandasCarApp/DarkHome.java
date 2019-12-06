package MetalPandasCarApp;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.h2.engine.Database;

import javax.xml.crypto.Data;

public class DarkHome {
  @FXML public SplitPane homeBackground;
  @FXML public VBox drawer;
  @FXML public HBox hBox;
  @FXML public ToolBar toolBar;
  @FXML public Button menuButton;
  @FXML public WebView maps;
  @FXML public ImageView profileImage;
  @FXML public Button profileButton;
  @FXML public Button favouritesButton;
  @FXML public Button logoutButton;
  @FXML public Button scheduleButton;
  @FXML public Button schedules;
  @FXML public Button addToFavourites;
  @FXML public ComboBox<String> endDestination;
  @FXML public ComboBox<String> startDestination;
  @FXML public Pane backDrop;
  @FXML public ComboBox<String> driver;

  public void handleMenuAction(ActionEvent actionEvent) {
    hBox.setVisible(true);
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

  public void handleLogoutAction(ActionEvent actionEvent) throws IOException {
    UsersInfo.usersScheduleGlobal.clear();
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleProfileAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavouritesAction(ActionEvent actionEvent) throws IOException, SQLException {
    addUserFavorites();
    Parent homePageParent = FXMLLoader.load(getClass().getResource("darkFavourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void initialize() {
    WebEngine engine = maps.getEngine();
    engine.load("https://www.google.com/maps/");
    try {
      driver.setItems(
          FXCollections.observableArrayList("Katy", "Kevin", "Owen", "Nick", "Odalys", "Jana"));
      startDestination.setItems(
          FXCollections.observableArrayList(
              "Target: 10000 Gulf Center Dr, Fort Myers, FL 33913",
              "FGCU West Lake: FGCU - West Lake Village, Fort Myers, FL 33967",
              "FGCU North Lake: FGCU North Lake, Fort Myers, FL 33965",
              "FGCU South Village: 10501 FGCU Blvd S, Fort Myers, FL 33965",
              "Publix: 20311 Grande Oak Blvd, Estero, FL 33928"));
      endDestination.setItems(
          FXCollections.observableArrayList(
              "Target: 10000 Gulf Center Dr, Fort Myers, FL 33913",
              "FGCU West Lake: FGCU - West Lake Village, Fort Myers, FL 33967",
              "FGCU North Lake: FGCU North Lake, Fort Myers, FL 33965",
              "FGCU South Village: 10501 FGCU Blvd S, Fort Myers, FL 33965",
              "Publix: 20311 Grande Oak Blvd, Estero, FL 33928"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void handleScheduleAction(ActionEvent actionEvent) {
    try {
      Parent homePageParent = FXMLLoader.load(getClass().getResource("darkSchedule.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void handleSchedulesAction(ActionEvent actionEvent) {
    try {
      Connection conn = DatabaseDriver.initializeDB();
      String sql = "SELECT * FROM SCHEDULE";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.executeQuery();

      Parent homePageParent = FXMLLoader.load(getClass().getResource("darkAppointments.fxml"));
      Scene homePageScene = new Scene(homePageParent);
      Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      homeStage.setScene(homePageScene);
      homeStage.show();

      conn.close();
      pstmt.close();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  public void handleAddFavouritesAction(ActionEvent event){
    addUserFavorites();
    Alert a = new Alert(AlertType.NONE);
    a.setAlertType(AlertType.INFORMATION);
    a.setContentText("Information has been added to your favourites!");
    a.show();
  }

  private void addUserFavorites(){
    try{
      String Driver = driver.getValue();
      String Start = startDestination.getValue();
      String End = endDestination.getValue();

      String[] signUpFavourites = {Driver, Start, End};

      DatabaseDriver.createFavouriteInDb(signUpFavourites);

      UsersFavourites favourites = new UsersFavourites(Driver, Start, End);
      UsersInfo.usersFavouritesGlobal.add(favourites);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
