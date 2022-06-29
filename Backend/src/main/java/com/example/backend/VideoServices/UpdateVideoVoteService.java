package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateVideoVoteService {

    public static void updateVote(String idToUpdate, String idToRemain){
        try {
            Connection dbConnection = DBConnector.getConnection();
            String updateVideo = "UPDATE youtube_rankings.allvideos SET allVotes=allVotes+1, positiveVotes=positiveVotes+1 WHERE id=?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(updateVideo);
            preparedStatement.setInt(1, Integer.parseInt(idToUpdate));
            preparedStatement.executeUpdate();
            String remainVideo = "UPDATE youtube_rankings.allvideos SET allVotes=allVotes+1 WHERE id=?";
            PreparedStatement remainPreparedStatement = dbConnection.prepareStatement(remainVideo);
            remainPreparedStatement.setInt(1, Integer.parseInt(idToRemain));
            remainPreparedStatement.executeUpdate();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
