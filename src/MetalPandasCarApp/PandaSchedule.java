package MetalPandasCarApp;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PandaSchedule {

  @FXML public AnchorPane scheduleBackground;
  @FXML public Text selectDateLabel;
  @FXML public ComboBox<String> scheduleMonth;
  @FXML public ComboBox<Integer> scheduleDay;
  @FXML public Text selectTimeLabel;
  @FXML public ComboBox<Integer> hour;
  @FXML public ComboBox<String> minute;
  @FXML public ComboBox<String> amPm;
  @FXML public Button schedule;
  @FXML public Button backButton;
  @FXML public Pane backDrop;

  public void handleScheduleAction(ActionEvent actionEvent) throws IOException, SQLException {
    addSchedule();
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaPayments.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void handleBackAction(ActionEvent actionEvent) throws IOException {
    Parent homePageParent = FXMLLoader.load(getClass().getResource("pandaHome.fxml"));
    Scene homePageScene = new Scene(homePageParent);
    Stage homeStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    homeStage.setScene(homePageScene);
    homeStage.show();
  }

  public void initialize() {
    try {
      scheduleMonth.setItems(
          FXCollections.observableArrayList(
              "January",
              "February",
              "March",
              "April",
              "May",
              "June",
              "July",
              "August",
              "September",
              "October",
              "November",
              "December"));
      scheduleDay.setItems(
          FXCollections.observableArrayList(
              1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
              25, 26, 27, 28, 29, 30, 31));
      hour.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
      minute.setItems(
          FXCollections.observableArrayList(
              "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
              "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
              "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41",
              "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55",
              "56", "57", "58", "59"));
      amPm.setItems(FXCollections.observableArrayList("AM", "PM"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addSchedule() throws SQLException {
    String ScheduleMonth = scheduleMonth.getValue();
    String ScheduleDay = scheduleDay.getValue().toString();
    String ScheduleHour = hour.getValue().toString();
    String ScheduleMinute = minute.getValue();
    String ScheduleApPm = amPm.getValue();

    String Time = scheduleMonth.getValue() + scheduleDay.getValue().toString();
    String Date = hour.getValue().toString() + minute.getValue();

    String[] scheduleSignUp = {
      ScheduleMonth, ScheduleDay, ScheduleHour, ScheduleMinute, ScheduleApPm
    };

    DatabaseDriver.createScheduleInDb(scheduleSignUp);

    UsersSchedule as = new UsersSchedule(Time, Date, ScheduleApPm);
    UsersInfo.usersScheduleGlobal.add(as);
  }
}
