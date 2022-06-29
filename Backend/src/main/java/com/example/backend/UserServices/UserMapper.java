package com.example.backend.UserServices;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static UserEntity userMapper(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        int id = resultSet.getInt(1);
        String username = resultSet.getString(2);
        String password = resultSet.getString(3);
        UserRoles.UserRole role = UserRoles.UserRole.valueOf(resultSet.getString(5));

        userEntity.setId(id);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setRole(role);

        return userEntity;
    }
}