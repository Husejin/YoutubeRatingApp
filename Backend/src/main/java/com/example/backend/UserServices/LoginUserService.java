package com.example.backend.UserServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserService {

    private static Connection dbConnection;

    public static LoginResponse checkUserCredentials(String username, String password) throws SQLException {
        LoginResponse loginResponse = new LoginResponse();
        dbConnection = DBConnector.getConnection();
        String getUserCredentials = "SELECT * FROM youtube_rankings.users WHERE username = ? AND password = ?;";
        PreparedStatement userCredentialsQuery = dbConnection.prepareStatement(getUserCredentials);
        userCredentialsQuery.setString(1, username);
        userCredentialsQuery.setString(2, password);
        ResultSet matchingUsers = userCredentialsQuery.executeQuery();
        if (matchingUsers.next()) {
            int userRoleIntValue = matchingUsers.getInt(4);
            String userRole = String.valueOf(UserRoles.UserRole.values()[userRoleIntValue]);


            loginResponse.setRole(userRole);
            loginResponse.setStatus("SUCCESS");
        }
        return loginResponse;
    }
}

