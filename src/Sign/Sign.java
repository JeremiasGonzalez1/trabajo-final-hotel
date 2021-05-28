package Sign;
import java.util.Date;
import java.io.*;
public class Sign implements Serializable{

    private String Username;
    private Date dateIn;
    private Date dateOut;

    public Sign(){}

    public Sign(String username, Date dateIn, Date dateOut) {
        Username = username;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

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
}
