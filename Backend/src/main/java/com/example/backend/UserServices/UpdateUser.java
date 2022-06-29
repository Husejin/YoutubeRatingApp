package com.example.backend.UserServices;

import com.example.backend.VideoServices.CommonVideosService;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


public class UpdateUser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameters = CommonVideosService.getRequestParameters(req);
        Gson gson = new Gson();
        UserEntity userToUpdate = gson.fromJson(parameters.get("userInfo")[0],UserEntity.class);
        try {
            UpdateUserService.persistUser(userToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CommonUserService.generateUserResponse(userToUpdate,resp);
    }
}
