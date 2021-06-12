package Interaction;
import java.time.LocalDate;
import java.util.List;

public class Check {
    private String dateIn;
    private String dateOut;
    private int idRoom=0;
    private Client client;

    public Check() {
    }

    public Check(LocalDate dateIn,int idRoom, Client client) {
        this.dateIn = dateIn.toString();
        this.idRoom=idRoom;
        this.client = client;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn.toString();
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public Client getClient() {
        return client;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean viewReservations(List<Reservation> reservationList) {

        for (Reservation reservation : reservationList) {
            if (reservation.getUsernameClient().equals(this.client.getUsername())) {
                System.out.println(this.getDateIn());
                if (reservation.getDateAdmission().equals(this.getDateIn())) {
                    this.setIdRoom(reservation.getNumRoom());
                    return true;
                }
            }
        }
        return false;
    }
}
