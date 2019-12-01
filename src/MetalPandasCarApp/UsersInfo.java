package MetalPandasCarApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

class UsersInfo {
  static ArrayList<Users> userProfilesGlobal = new ArrayList<>();

  static ArrayList<UsersCardPayment> usersCardPaymentGlobal = new ArrayList<>();

  static ObservableList<UsersSchedule> usersScheduleGlobal = FXCollections.observableArrayList();

}