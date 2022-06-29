package com.example.backend.VideoServices;


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
    //Iz baze dohvatamo koliko zelimo vieda po ranku, a da ne bi gubili efikasnost s povecanjem broja videa u bazi podataka koristimo
    //limit i offset za query, pa tako da ako nas interesuje za mini tabelu 5 mozemo reci limit 5 offset 0,
    //ako nas interesuje zaseban page u rankings tabeli to mozemo reci ovako
}
