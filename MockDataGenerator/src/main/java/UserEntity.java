public class UserEntity {

    private int id;
    private String username;
    private String password;
    private UserRoles.UserRole role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles.UserRole getRole() {
        return role;
    }

    public void setRole(UserRoles.UserRole role) {
        this.role = role;
    }
}