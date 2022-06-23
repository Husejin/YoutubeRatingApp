package com.example.backend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(value = "/deleteSingleVideo")
public class DeleteVideo  extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        try {
            DeleteVideoService.deleteVideo(parameters.get("id")[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
