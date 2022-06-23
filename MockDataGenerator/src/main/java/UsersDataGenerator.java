import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDataGenerator {
    private static Connection dbConnection;

    private static void insertUser(UserEntity userEntity) throws SQLException {
        dbConnection = DBConnector.getConnection();
        String insertAdminUser = "INSERT INTO youtube_rankings.users VALUES(null,?,?,?);";
        PreparedStatement insertStatement = dbConnection.prepareStatement(insertAdminUser);
        insertStatement.setString(1,userEntity.getUsername());
        insertStatement.setString(2,userEntity.getPassword());
        insertStatement.setInt(3,userEntity.getRole().ordinal());
        insertStatement.executeUpdate();
        dbConnection.close();
    }

    public static void generateAdminUser() throws SQLException {

        UserEntity adminUser = new UserEntity();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        adminUser.setRole(UserRoles.UserRole.ADMIN);
        insertUser(adminUser);
    }
}
