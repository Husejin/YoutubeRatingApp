package com.example.backend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "generateTwoVideos", value = "/getRandomVideosPair")
public class GenerateTwoVideos extends HttpServlet {

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
         CommonVideosService.generateVideosResponse(GenerateTwoVideosService.fetchVideoPairFromDatabase(),response);
    }
}