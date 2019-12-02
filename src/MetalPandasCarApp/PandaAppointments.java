package MetalPandasCarApp;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.naming.Binding;

public class PandaAppointments implements Initializable {
  @FXML public SplitPane appointmentsBackground;
  @FXML public ToolBar toolBar;
  @FXML public Button menuButton;
  @FXML public VBox drawer;
  @FXML public HBox hBox;
  @FXML public ImageView profileImage;
  @FXML public Button profileButton;
  @FXML public Button favouritesButton;
  @FXML public Button homeButton;
  @FXML public Button logoutButton;
  @FXML public TableView<UsersSchedule> scheduledPickUps;
  @FXML public TableColumn<?, ?> dateColumn;
  @FXML public TableColumn<?, ?> timeColumn;
  @FXML public TableColumn<?, ?> destinationColumn;

  void setAppointmentPage(ObservableList<UsersSchedule> usersScheduleGlobal) {
    try {
      Connection conn = DatabaseDriver.initializeDB();
      String sql = "SELECT * FROM SCHEDULE";

      Statement stmt = conn.createStatement();

      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        String month = rs.getString(1);
        String day = rs.getString(2);
        String hour = rs.getString(3);
        String minute = rs.getString(4);
        String amPm = rs.getString(5);

        String time = rs.getString(1) + " , " + rs.getString(2);
        String date = rs.getString(3) + " : " + rs.getString(4);

        UsersSchedule items = new UsersSchedule(month, day, hour, minute, amPm);
        UsersSchedule info = new UsersSchedule(time,date,amPm);
        usersScheduleGlobal.add(items);
        usersScheduleGlobal.add(info);
      }

      scheduledPickUps.setItems(usersScheduleGlobal);

      dateColumn.setCellValueFactory(new PropertyValueFactory("time"));
      timeColumn.setCellValueFactory(new PropertyValueFactory("date"));

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

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
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaLogin.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleProfileAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaProfile.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleHomeAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaHome.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleFavouritesButton(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaFavourites.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
//    UsersInfo.userProfilesGlobal.clear();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    setAppointmentPage(UsersInfo.usersScheduleGlobal);
  }

}
