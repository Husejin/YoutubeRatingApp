package com.example.backend.UserServices;

import com.example.backend.VideoServices.CommonVideosService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet (value = "/getUsers")
public class GenerateUsers extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        try {
            CommonUserService.generateUserResponse(GenerateUsersService.generateUsers(parameters.get("limit")[0],parameters.get("offset")[0]),resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
