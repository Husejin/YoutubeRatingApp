package com.example.backend;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GenerateTwoVideosService {
    public static List<VideoEntity> fetchVideosFromDatabase() {
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

    public static void generateVideoPairResponse(List<VideoEntity> videoEntities, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        response.getWriter().println(gson.toJsonTree(videoEntities));
    }
}
