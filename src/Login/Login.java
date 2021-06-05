package Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import UtilitiesFiles.DataFile;
public class Login implements Serializable{
    private String username = "";
    private String password = "";

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
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

    public boolean confirmUser(Login login, String path) {
        int i = 0;
        boolean flag = false;

        List <Login> logins = new ArrayList<>();

        DataFile data = new DataFile();

        logins = data.listLogin(path);

        for(Login aux : logins){
            if (login.equals(aux)) {
                flag = true;
                break;
            }
        }

        return flag;
    }


}
