package com.example.backend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet(value = "/updateVideoVote")
public class UpdateVideoVote extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        UpdateVideoVoteService.updateVote(parameters.get("idToUpdate")[0],parameters.get("idToRemain")[0]);
    }
}
