package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateSpecificVideoService {
    public static VideoEntity fetchSpecificVideo(String id) {
        VideoEntity video = null;
        try {
            Connection dbConnection = DBConnector.getConnection();
            String selectVideoPair = "SELECT * FROM youtube_rankings.allVideos WHERE id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectVideoPair);
            preparedStatement.setInt(1,Integer.parseInt(id));

            ResultSet results = preparedStatement.executeQuery();
            if (results.next()) {
                video = VideoMapper.asVideoEntity(results);
            }
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }
}
