package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSpecificVideoService {
    private static Connection connection;

    public static void persistVideo(VideoEntity videoEntity) throws SQLException {
        connection = DBConnector.getConnection();
        String persistVideoString = "UPDATE youtube_rankings.allvideos SET name=?, url=?, thumbnailUrl=? WHERE id = ?";
        PreparedStatement persistVideoQuery = connection.prepareStatement(persistVideoString);
        persistVideoQuery.setString(1,videoEntity.getName());
        persistVideoQuery.setString(2,videoEntity.getUrl());
        persistVideoQuery.setString(3,videoEntity.getThumbnailUrl());
        persistVideoQuery.setInt(4,videoEntity.getId());
        persistVideoQuery.executeUpdate();
        connection.close();
    }
}
