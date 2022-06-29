package com.example.backend.UserServices;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommonUserService {
    public static void generateUserResponse(UserEntity userEntity, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(userEntity));
    }
}
