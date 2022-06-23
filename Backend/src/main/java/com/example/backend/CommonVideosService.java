package com.example.backend;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonVideosService {

    public static void generateVideosResponse(List<VideoEntity> videoEntities, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        response.getWriter().println(gson.toJsonTree(videoEntities));
    }
    public static void generateVideosResponse(VideoEntity videoEntity, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(videoEntity));
    }

    public static void generateLoginResponse(LoginResponse loginResponse, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(loginResponse));
    }
    
    public static Map<String, String[]> getRequestParameters(HttpServletRequest req)
    {
        return Collections.list(req.getParameterNames())
                .stream()
                .collect(Collectors.toMap(parameterName -> parameterName, req::getParameterValues));
    }
}
