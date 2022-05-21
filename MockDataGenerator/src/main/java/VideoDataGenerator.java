import com.github.javafaker.Faker;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VideoDataGenerator {
    private static int numberOfVideosToGenerate = 10;
    private static Connection dbConnection;

    public static void reloadDatabase() throws SQLException, FileNotFoundException {
        dbConnection = DBConnector.getConnection();
        ScriptRunner sr = new ScriptRunner(dbConnection);
        Reader reader = new BufferedReader(new FileReader("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.0\\webapps\\YoutubeRatingsApp2\\MockDataGenerator\\dbScripts\\bootUp.sql"));
        sr.runScript(reader);
        dbConnection.close();
    }

    public static void generateVideos() throws SQLException {
        dbConnection = DBConnector.getConnection();
        try {
            List<VideoEntity> randomVideos = new ArrayList<>();
            Statement insertVideos = dbConnection.createStatement();
            String insertVideosQuery = "INSERT INTO youtube_rankings.allVideos VALUES ";

            for (int i = 0; i < numberOfVideosToGenerate; i++) {
                VideoEntity videoToAdd = generateRandomVideo(i+1);
                randomVideos.add(videoToAdd);
                insertVideosQuery += getValuesString(videoToAdd);
                if (i + 1 < numberOfVideosToGenerate) {
                    insertVideosQuery += ", ";
                }
            }
            insertVideosQuery += ";";
            dbConnection.prepareStatement(insertVideosQuery).executeUpdate();
            System.out.println("Videos added successfully");
        } catch (SQLException s) {
            s.printStackTrace();
        }
        dbConnection.close();
    }

    private static String getValuesString(VideoEntity entity) {
        String valueString = "(null, ";
        valueString += "'" + entity.getName() + "',";
        valueString += "'" + entity.getDescription() + "',";
        valueString += entity.getAllVotes() + ",";
        valueString += entity.getPositiveVotes() + ",";
        valueString += "'" + entity.getUrl() + "',";
        valueString += "'" + entity.getThumbnailUrl() + "')";
        return valueString;
    }

    private static VideoEntity generateRandomVideo(int generationNumber) {
        int randomIndex = (new Random()).nextInt(10);
        Faker generator = new Faker();
        String name = VideoResources.getRandomVideoTitle(randomIndex) + " " + generationNumber;
        String url = VideoResources.getRandomVideoURL(randomIndex);
        String thumbnail = VideoResources.getRandomVideoThumbnailUrl(randomIndex);
        String description = generator.esports().event() + " " + generationNumber;
        return new VideoEntity(name, description, 0, 0, url, thumbnail);
    }
}
