package Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public boolean confirmUser() {

        String path = ":C//User//Desktop//login.txt";

        File file = new File(path);

        boolean flag = false;

        try {
            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(file));

            Object aux = objInStream.readObject();

            while(aux != null && !flag)
            {
                if(aux.equals(this))
                {
                    flag = true;
                }

                aux = objInStream.readObject();
            }

            objInStream.close();

        } catch (IOException | ClassNotFoundException ignored) {
        }


        return flag;
    }


}
