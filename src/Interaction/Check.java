package Interaction;

import Empleados.Receptionist;

import java.util.Date;
import java.util.List;

public class Check {
    private Date dateIn;
    private Date dateOut;
    private int idRoom=0;
    private Client client;

    public Check() {
    }

    public Check(Date dateIn,int idRoom, Client client) {
        this.dateIn = dateIn;
        this.idRoom=idRoom;
        this.client = client;
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
            if (reservation.getUsernameClient() == this.client.getUsername()) {
                if (reservation.getDateAdmission() == this.getDateIn()) {
                    this.setIdRoom(reservation.getNumRoom());
                    return true;
                }
            }
        }
        return false;
    }
}
