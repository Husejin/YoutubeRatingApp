package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenerateRankedVideosService {

    public static List<VideoEntity> generateRankedVideos(String limit, String offset) {
        List<VideoEntity> rankedVideos = new ArrayList<>();
        try {
            Connection dbConnection = DBConnector.getConnection();
            String selectRankedVideos = "SELECT *, ((positiveVotes + 1.9208) / (positiveVotes + allVotes-positiveVotes) -\n" +
                    "                   1.96 * SQRT((positiveVotes * allVotes-positiveVotes) / (positiveVotes + allVotes-positiveVotes) + 0.9604) /\n" +
                    "                   (positiveVotes + allVotes-positiveVotes)) / (1 + 3.8416 / (positiveVotes + allVotes-positiveVotes))\n" +
                    "    AS ci_lower_bound FROM youtube_rankings.allvideos WHERE positiveVotes + allVotes-positiveVotes > 0\n" +
                    "ORDER BY ci_lower_bound DESC LIMIT ? OFFSET ?;";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectRankedVideos);
            preparedStatement.setInt(1, Integer.parseInt(limit));
            preparedStatement.setInt(2, Integer.parseInt(offset));
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                rankedVideos.add(VideoMapper.asVideoEntity(results));
            }
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rankedVideos;
    }

}
