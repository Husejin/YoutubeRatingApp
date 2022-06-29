package com.example.backend.UserServices;

import com.example.backend.VideoServices.CommonVideosService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet (value = "/registerUser")
public class RegisterUser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        Gson gson = new Gson();
        UserEntity userToCreate = gson.fromJson(parameters.get("userInfo")[0],UserEntity.class);
        try {
            if(!RegisterUserService.registerUser(userToCreate))
            {
                userToCreate.setUsername("#");
            }
            CommonUserService.generateUserResponse(userToCreate,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
