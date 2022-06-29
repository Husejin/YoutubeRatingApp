package com.example.backend.VideoServices;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class VideoMapper {

public static VideoEntity asVideoEntity(ResultSet results) throws SQLException {
    int id=results.getInt(1);
    String name = results.getString(2);
    String description = results.getString(3);
    int allVotes = results.getInt(4);
    int positiveVotes = results.getInt(5);
    String url = results.getString(6);
    String thumbnailUrl = results.getString(7);
    String blobString=null;
    if(results.getBlob(8)!=null)
    {
        Blob blob =  results.getBlob(8);
        byte[] bytes = blob.getBytes(1l, (int) blob.length());

         blobString =  Base64.getEncoder().encodeToString(bytes);
    }


    return new VideoEntity(id,name,description,allVotes,positiveVotes,url,thumbnailUrl,blobString );
}
}

