package TestModel;

public class UserCredentials {
    private String email;
    private String password;

    public UserCredentials(UserModel user){
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static UserCredentials from (UserModel user){
        return new UserCredentials(user);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
