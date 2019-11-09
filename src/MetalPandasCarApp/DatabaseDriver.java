package MetalPandasCarApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseDriver {
  private static String querySQL;
  private static Connection conn;
  private PreparedStatement pstmt;

  public static Connection initializeDB() {
    // Connection establish.

    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./Lib/MetalPandasDB";

    final String USER = "";
    final String PASS = "";

    try {
      Class.forName(jdbcDriver);

      conn = DriverManager.getConnection(dbUrl, USER, PASS);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  // Creates a USER of datatype String.
  // Accepts USER inputs from the TexFields, PasswordFields, ChoiceBox and ComboBox.
  // Loops through the values and increments each time, stops after country.
  public static void createUserInDB(String[] signUpUser) throws SQLException {
    querySQL = "INSERT INTO USER(firstName, lastName, email,  address, country, phoneNumber,"
            + " password, personType,  gender) VALUES (?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = conn.prepareStatement(querySQL);

    int i = 1;
    for (String str : signUpUser) {
      pstmt.setString(i, str);
      i++;
    }
    pstmt.executeUpdate();

    System.out.println("User Created!");
  }

  /** ODALYS START CODE **/
  public static void updateUserInDB(String[] userUpdate) throws SQLException {
     // querySQL = "INSERT INTO USER(firstName, lastName, email,  address, country, phoneNumber,"
             // + " password, personType,  gender) VALUES (?,?,?,?,?,?,?,?,?)";
      querySQL = "UPDATE USER SET FIRSTNAME, LASTNAME, EMAIL, ADDRESS, COUNTRY, PHONENUMBER,"
              + "PERSONTYPE";

      PreparedStatement pstmt = conn.prepareStatement(querySQL);

      int i = 1;
      for (String str : userUpdate) {
          pstmt.setString(i, str);
          i++;
      }
      pstmt.executeUpdate();

      System.out.println("User Updated!");
  }
  /** ODALYS END CODE **/
}
