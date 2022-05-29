package com.example.backend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(value = "/generateSpecificVideosPair")
public class GenerateSpecificVideosPair extends HttpServlet
{
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(request);
        String id1 = parameters.get("id1")[0];
        String id2 = parameters.get("id2")[0];
        try {
            CommonVideosService.generateVideosResponse(GenerateTwoVideosService.fetchSpecificVideoPairFromDatabase(id1,id2),response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
