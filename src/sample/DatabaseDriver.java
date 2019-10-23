package sample;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    public class DatabaseDriver {
        private static String querySQL;
        private static Connection conn;
        private PreparedStatement pstmt;

        public static void initializeDB() {
            // Connection establish.

            final String jdbcDriver = "org.h2.Driver";
            final String dbUrl = "jdbc:h2:./Lib/ProductDB";

            final String USER = "";
            final String PASS = "";

            try {
                Class.forName(jdbcDriver);

                conn = DriverManager.getConnection(dbUrl, USER, PASS);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        public static void createUserInDB(
                TextField firstName,
                TextField lastName,
                TextField email,
                TextField address,
                TextField pickCountry,
                TextField phoneNumber,
                PasswordField enterPassword,
                DatePicker birthday,
                ChoiceBox<String> driverPass,
                ChoiceBox<String> gender) throws SQLException {
            String FirstName = firstName.getText();
            String LastName = lastName.getText();
            String Email = email.getText();
            String Address = address.getText();
            String PickCountry = pickCountry.getText();
            String PhoneNum = phoneNumber.getText();
            String EnterPass = enterPassword.getText();
            String Birthday = birthday.toString();
            String DriverPass = driverPass.getValue();
            String Gender = gender.getValue();

            String[] signUpItems = { FirstName, LastName, Email, Address, PickCountry, PhoneNum,
                    EnterPass, Birthday, DriverPass, Gender};

            querySQL = "INSERT INTO USER(firstName, lastName, password, email, phoneNumber, "
                    + "birth_date, gender, personType, country) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(querySQL);

            int i = 1;
            for (String str : signUpItems ) {
                pstmt.setString(i,str);
                i++;
            }
            pstmt.executeUpdate();

            System.out.println("User Created!");

        }


    }
