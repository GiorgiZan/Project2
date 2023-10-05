package DB;

import org.testng.annotations.Test;

import java.sql.*;

public class SQLQuery {
//    public static void insertUser(String firstName, String lastName, String phone, String email, java.sql.Date dateOfBirth, String password) {
//        try (Connection connection = DbConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO users (firstName, lastName, phone, email, dateOfBirth, password) VALUES (?, ?, ?, ?, ?, ?)")) {
//
//            preparedStatement.setString(1, firstName);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setString(3, phone);
//            preparedStatement.setString(4, email);
//            preparedStatement.setDate(5, dateOfBirth);
//            preparedStatement.setString(6, password);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected != 1) {
//                throw new RuntimeException("Insert operation failed");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error while inserting user data", e);
//        }
//    }

    //java.sql.Date
    public static int insertUser(String firstName, String lastName, String phone, String email, java.sql.Date dateOfBirth, String password) {
        int generatedUserId = -1;

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO users (firstName, lastName, phone, email, dateOfBirth, password) VALUES (?, ?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setDate(5, dateOfBirth);
            preparedStatement.setString(6, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 1) {
                throw new RuntimeException("Insert operation failed");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedUserId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while inserting user data", e);
        }

        return generatedUserId;
    }


    public static void deleteUserById(int userId) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {

            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 1) {
                throw new RuntimeException("Delete operation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting user by ID", e);
        }
    }



}
