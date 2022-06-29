package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class UpdateSpecificVideoService {
    private static Connection connection;

    public static void persistVideo(VideoEntity videoEntity) throws SQLException {
        connection = DBConnector.getConnection();
        String persistVideoString = "UPDATE youtube_rankings.allvideos SET name=?, url=?, thumbnailUrl=? WHERE id = ?";
        PreparedStatement persistVideoQuery = connection.prepareStatement(persistVideoString);
        persistVideoQuery.setString(1, videoEntity.getName());
        persistVideoQuery.setString(2, videoEntity.getUrl());
        persistVideoQuery.setString(3, videoEntity.getThumbnailUrl());
        persistVideoQuery.setInt(4, videoEntity.getId());
        persistVideoQuery.executeUpdate();
        connection.close();
    }

    public static void persistVideoWithAlternateImage(VideoEntity videoEntity) throws SQLException {
        connection = DBConnector.getConnection();
        String persistVideoString = "UPDATE youtube_rankings.allvideos SET name=?, url=?, thumbnailUrl=?, alternateImage=? WHERE id = ?";
        PreparedStatement persistVideoQuery = connection.prepareStatement(persistVideoString);
        persistVideoQuery.setString(1, videoEntity.getName());
        persistVideoQuery.setString(2, videoEntity.getUrl());
        persistVideoQuery.setString(3, videoEntity.getThumbnailUrl());
        persistVideoQuery.setBytes(4, Base64.getDecoder().decode(videoEntity.getAlternateImage()));
        persistVideoQuery.setInt(5, videoEntity.getId());
        persistVideoQuery.executeUpdate();
        connection.close();

    }
}
