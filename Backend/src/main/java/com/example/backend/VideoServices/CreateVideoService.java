package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class CreateVideoService {
    private static Connection connection;

    public static VideoEntity createVideo(VideoEntity videoEntity) throws SQLException {
        connection= DBConnector.getConnection();
        String createVideoString = "INSERT INTO allvideos VALUES (?,?,?,?,?,?,?,?);";

        PreparedStatement createVideoQuery = connection.prepareStatement(createVideoString);
        createVideoQuery.setInt(1,videoEntity.getId());
        createVideoQuery.setString(2,videoEntity.getName());
        createVideoQuery.setString(3,"new description");
        createVideoQuery.setInt(4,0);
        createVideoQuery.setInt(5,0);
        createVideoQuery.setString(6,videoEntity.getUrl());
        createVideoQuery.setString(7,videoEntity.getThumbnailUrl());
        createVideoQuery.setBytes(8, Base64.getDecoder().decode(videoEntity.getAlternateImage()));
        createVideoQuery.executeUpdate();
        connection.close();
        return  videoEntity;
    }
}
