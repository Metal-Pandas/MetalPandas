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
  private static ArrayList<UsersPayment> userPayment = new ArrayList();

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
   * Creates a USER of datatype String. Accepts USER inputs from the TexFields, PasswordFields,
   * ChoiceBox and ComboBox. Loops through the values and increments each time, stops after country.
   *
   * @param signUpUser an array of strings.
   * @throws SQLException
   */
  public static void createUserInDB(String[] signUpUser) throws SQLException {
    try {
      String querySQL =
          "INSERT INTO USER( firstName, lastName, email, phoneNumber, address, city, state, zip, country, password,"
              + "month, day, year, gender, personType) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

  public static ArrayList<Users> getUserInfo(String mail) {
    try {
      initializeDB();

      querySQL = "SELECT * FROM USER WHERE EMAIL = ?";

      pstmt = conn.prepareStatement(querySQL);

      pstmt.setString(1, mail);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        mail = rs.getString("email");
        String phoneNumber = rs.getString("phoneNumber");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String zip = rs.getString("zip");
        String country = rs.getString("country");
        String password = rs.getString("password");
        String month = rs.getString("month");
        String day = rs.getString("day");
        String year = rs.getString("year");
        String gender = rs.getString("gender");
        String pType = rs.getString("personType");

        userInfo.add(
            new Users(
                firstName,
                lastName,
                mail,
                phoneNumber,
                address,
                city,
                state,
                zip,
                country,
                password,
                month,
                day,
                year,
                gender,
                pType));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return userInfo;
  }

  public static void createPaymentInDb(String[] paymentSignUp) throws SQLException {
    try {
      querySQL =
          "INSERT INTO PAYMENT(paymentCombo, cardHolder, cardNumber, ccvNumber, expirationMonth, expirationYear) VALUES (?,?,?,?,?,?)";

      pstmt = conn.prepareStatement(querySQL);

      int i = 1;
      for (String str1 : paymentSignUp) {
        pstmt.setString(i, str1);
        i++;
      }
      pstmt.executeUpdate();

      System.out.println("Payment Created!");
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<UsersPayment> getPaymentInfo(String paymentType) {
    try {
      initializeDB();

      querySQL = "SELECT * FROM PAYMENT WHERE PAYMENTCOMBO = ?";

      pstmt = conn.prepareStatement(querySQL);

      pstmt.setString(1, paymentType);

      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        paymentType = rs.getString("paymentCombo");
        String cardName = rs.getString("cardHolder");
        String ccv = rs.getString("ccvNumber");
        String cardNumber = rs.getString("cardNumber");
        String expMonth = rs.getString("expirationMonth");
        String expYear = rs.getString("expirationYear");

        userPayment.add(
            new UsersPayment(paymentType, cardName, ccv, cardNumber, expMonth, expYear));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    return userPayment;
  }
}
