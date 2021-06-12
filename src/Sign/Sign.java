package Sign;
import UtilitiesFiles.DataFile;
import java.time.LocalDateTime;
import java.io.*;
import java.util.List;

public class Sign implements Serializable{

    private String Username;
    private String dateIn;
    private String dateOut;

    public Sign(){}

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "EMPLEADO : " + Username +
                "DE : " + dateIn +
                "HASTA : " + dateOut +
                "\n\n";
    }

    public boolean signIn(String username){
        LocalDateTime time = LocalDateTime.now();
        String date = time.toString();
        this.setDateIn(date);
        this.setDateOut(null);
        this.setUsername(username);
        return true;
    }

    public void signOut(List<Sign> signList) {

        LocalDateTime time = LocalDateTime.now();
        String date = time.toString();
        this.setDateOut(date);
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
