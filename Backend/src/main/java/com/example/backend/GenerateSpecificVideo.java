package com.example.backend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/generateSpecificVideo")
public class GenerateSpecificVideo extends HttpServlet {
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(request);
        String id = parameters.get("id")[0];
        CommonVideosService.generateVideosResponse(GenerateSpecificVideoService.fetchSpecificVideo(id),response);
    }
}
