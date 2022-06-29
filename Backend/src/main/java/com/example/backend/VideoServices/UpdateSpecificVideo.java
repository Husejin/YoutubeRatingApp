package com.example.backend.VideoServices;


import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


@WebServlet (value = "/updateSpecificVideo")
public class UpdateSpecificVideo extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        Gson gson = new Gson();
        VideoEntity videoToUpdate = gson.fromJson(parameters.get("videoInfo")[0],VideoEntity.class);
        try {
            if ((videoToUpdate.getAlternateImage() != null)) {
                UpdateSpecificVideoService.persistVideoWithAlternateImage(videoToUpdate);
            } else {
                UpdateSpecificVideoService.persistVideo(videoToUpdate);
            }
            CommonVideosService.generateVideosResponse(videoToUpdate,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
