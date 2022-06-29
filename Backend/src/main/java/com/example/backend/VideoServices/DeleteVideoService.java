package com.example.backend.VideoServices;

import com.example.backend.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteVideoService {
    private static Connection connection;
    public static void deleteVideo(String videoId) throws SQLException {
        connection= DBConnector.getConnection();
        String deleteVideoString = "DELETE FROM allvideos WHERE id=?";
        PreparedStatement deleteVideoQuery = connection.prepareStatement(deleteVideoString);
        deleteVideoQuery.setInt(1,Integer.parseInt(videoId));
        deleteVideoQuery.executeUpdate();
        connection.close();
    }
}
