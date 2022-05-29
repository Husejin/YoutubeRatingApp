package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GenerateTwoVideosService {
    public static List<VideoEntity> fetchRandomVideoPairFromDatabase() {
        List<VideoEntity> videoPair = new ArrayList<>();
        try {
            Connection dbConnection = DBConnector.getConnection();
            String selectRandomVideosQuery = "SELECT * FROM youtube_rankings.allVideos AS t1 JOIN (SELECT id FROM youtube_rankings.allVideos ORDER BY RAND() LIMIT 2) as t2 ON t1.id=t2.id";
            ResultSet results = dbConnection.prepareStatement(selectRandomVideosQuery).executeQuery();
            while (results.next()) {
                videoPair.add(VideoMapper.asVideoEntity(results));
            }
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videoPair;
    }

    public static List<VideoEntity> fetchSpecificVideoPairFromDatabase(String firstVideoId, String secondVideoId) throws SQLException {
        List<VideoEntity> videoPair = new ArrayList<>();
        try {
            Connection dbConnection = DBConnector.getConnection();
            String selectVideoPair = "SELECT * FROM youtube_rankings.allVideos WHERE id = ? OR id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectVideoPair);
            preparedStatement.setInt(1,Integer.parseInt(firstVideoId));
            preparedStatement.setInt(2,Integer.parseInt(secondVideoId));
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                videoPair.add(VideoMapper.asVideoEntity(results));
            }
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videoPair;
    }
}
