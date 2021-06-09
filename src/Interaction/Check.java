package Interaction;

import Empleados.Receptionist;

import java.util.Date;
import java.util.List;

public class Check {
    private Date date;
    private int idRoom=0;
    private Client client;

    public Check() {
    }

    public Check(Date date,int idRoom, Client client) {
        this.date = date;
        this.idRoom=idRoom;
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                if (reservation.getDateAdmission() == this.getDate()) {
                    this.setIdRoom(reservation.getNumRoom());
                    return true;
                }
            }
        }
        return false;
    }
}
