package MetalPandasCarApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseDriver {

  private static String querySQL;
  private static Connection conn;
  private static PreparedStatement pstmt;

  private static ArrayList<Users> userInfo = new ArrayList();

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

  /**
   * Creates a USER of datatype String.
   * Accepts USER inputs from the TexFields, PasswordFields, ChoiceBox and ComboBox.
   *  Loops through the values and increments each time, stops after country.
   *
   * @param signUpUser an array of strings.
   * @throws SQLException
   */
  public static void createUserInDB(String[] signUpUser) throws SQLException {
    try {
      querySQL =
              "INSERT INTO USER(firstName, lastName, email,  address, country, phoneNumber,"
                      + " password, personType,  gender) VALUES (?,?,?,?,?,?,?,?,?)";

      pstmt = conn.prepareStatement(querySQL);

      int i = 1;
      for (String str : signUpUser) {
        pstmt.setString(i, str);
        i++;
      }
      pstmt.executeUpdate();

      System.out.println("User Created!");
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   *
   * @param mail
   * @return
   */
  public static ArrayList<Users> getUserInfo(String mail) {
    try {
      initializeDB();

      //
      querySQL = "SELECT * FROM USER WHERE EMAIL = ?";

      PreparedStatement pstmt = conn.prepareStatement(querySQL);

      pstmt.setString(1, mail);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        mail = rs.getString("email");
        String address = rs.getString("address");
        String country = rs.getString("country");
        String phoneNumber = rs.getString("phoneNumber");
        String pType = rs.getString("personType");

        userInfo.add(new Users(firstName, lastName, mail, address, country, phoneNumber, pType));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return userInfo;
  }


  /** START CODE **/
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
  /** END CODE **/

}
