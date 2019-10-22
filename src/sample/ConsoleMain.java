package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsoleMain  {
  public static void main(String[] a) throws Exception {
    System.out.println("Controller Driver Class");
    Connection conn = DriverManager.getConnection("jdbc:h2:./Lib/MetalPandasDB", "", "");

    System.out.println("Connected database successfully...");
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM LOGIN_RECORD where email=? and password=?";
    ResultSet rs = stmt.executeQuery(query);
    System.out.println(rs);
  if(!rs.next()){
      System.out.println("Wrong email and password");
  }
    while (rs.next()) {
      //checks the column, rows, position location from the database.
      int id = rs.getInt("ID");
      String email = rs.getString("EMAIL");
      String password = rs.getString("PASSWORD");

      //Checking the database for ID,Email, Password
      System.out.println("ID: " + id);
      System.out.println("Email: " + email);
      System.out.println("Password: " + password);
    }
    rs.close();
    conn.close();
  }

}
