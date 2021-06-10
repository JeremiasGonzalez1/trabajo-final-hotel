package Sign;
import UtilitiesFiles.DataFile;

import java.util.Date;
import java.io.*;
import java.util.List;

public class Sign implements Serializable{

    private String Username;
    private Date dateIn;
    private Date dateOut;

    public Sign(){}

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "Username='" + Username + '\'' +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }

    public boolean signIn(String username){
        Date date = new Date();
        this.setDateIn(date);
        this.setDateOut(null);
        this.setUsername(username);
        return true;
    }

    public void signOut(List<Sign> signList) {
        Date date = new Date();
        DataFile data = new DataFile();

        this.setDateOut(date);

        signList = data.readLists("sign.json", Sign.class);

        signList.add(this);

        data.saveOnFile(signList, "sign.json");
    }

    public void seeSigns(List <Sign> signsList, String username){

        for(Sign sign : signsList){
            if(sign.getUsername().equals(username)){
                System.out.println(sign.toString());
            }
        }

    }
}
