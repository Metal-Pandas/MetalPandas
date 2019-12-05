package MetalPandasCarApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// Users Info
class UsersInfo {
  static ObservableList<Users> userProfilesGlobal = FXCollections.observableArrayList();

  static ObservableList<UsersSchedule> usersScheduleGlobal = FXCollections.observableArrayList();

  static ObservableList<UsersFavourites> usersFavouritesGlobal = FXCollections.observableArrayList();
}