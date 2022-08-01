package TestModel;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserModel {

    private String email;
    private String name;
    private String password;

    public UserModel(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserModel getRandom () {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String name = faker.name().fullName();
        String password = RandomStringUtils.randomAlphabetic(10);

        return new UserModel(email, name, password);
    }
}
