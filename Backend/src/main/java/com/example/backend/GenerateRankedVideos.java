package com.example.backend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/generateRankedVideos")
public class GenerateRankedVideos extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        CommonVideosService.generateVideosResponse(GenerateRankedVideosService.generateRankedVideos(parameters.get("limit")[0],parameters.get("offset")[0]),resp);
    }
}
