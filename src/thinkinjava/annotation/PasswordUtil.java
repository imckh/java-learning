package thinkinjava.annotation;


import java.util.List;

public class PasswordUtil {

    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePasword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "密码不能和之前的重复")
    public boolean checkForNewPassword(List<String> passwords, String password) {
        return !passwords.contains(password);
    }
}
