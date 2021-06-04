package Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public boolean confirmUser(Login login) {

        String path = ":C//User//Desktop//login.json";

        File file = new File(path);

        boolean flag = false;

        try {
            ObjectMapper mapper = new ObjectMapper();

            ArrayList<Login> logins = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Login.class));

            for(Login aux : logins)
            {
                if(aux.equals(login))
                {
                    flag = true;
                }
            }

        } catch (IOException ignored) {
        }

        return flag;
    }


}
