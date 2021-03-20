package fianso.io.pidza.models;

public class LoginForm {
    private String username;
    private String password;

    public LoginForm(String username, String password){
        this.password=password;
        this.username=username;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}
