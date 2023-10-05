package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUser {

public static Map<String, String> fetchUserById(int userId) {
    Map<String, String> userData = new HashMap<>();

    try (Connection connection = DbConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT id, firstName, lastName, phone, email, CONVERT(VARCHAR(50), dateOfBirth, 101) AS dateOfBirth, password FROM users WHERE id = ?")) {

        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            userData.put("id", String.valueOf(resultSet.getInt("id")));
            userData.put("firstName", resultSet.getString("firstName"));
            userData.put("lastName", resultSet.getString("lastName"));
            userData.put("phone", resultSet.getString("phone"));
            userData.put("email", resultSet.getString("email"));
            userData.put("dateOfBirth", resultSet.getString("dateOfBirth"));
            userData.put("password", resultSet.getString("password"));
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error while fetching user data", e);
    }

    return userData;
}
}
