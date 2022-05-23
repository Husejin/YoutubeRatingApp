package com.example.backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoMapper {

public static VideoEntity asVideoEntity(ResultSet results) throws SQLException {
    int id=results.getInt(1);
    String name = results.getString(2);
    String description = results.getString(3);
    int allVotes = results.getInt(4);
    int positiveVotes = results.getInt(5);
    String url = results.getString(6);
    String thumbnailUrl = results.getString(7);
    return new VideoEntity(id,name,description,allVotes,positiveVotes,url,thumbnailUrl);
}



}

