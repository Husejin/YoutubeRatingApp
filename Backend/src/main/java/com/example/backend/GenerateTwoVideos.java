package com.example.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "generateTwoVideos", value = "/getRandomVideosPair")
public class GenerateTwoVideos extends HttpServlet {

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
         GenerateTwoVideosService.generateVideoPairResponse(GenerateTwoVideosService.fetchVideosFromDatabase(),response);
    }
}