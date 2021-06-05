package Utils;

import Interaction.Reservation;

import java.util.List;

public class ListReservations {
    private List<Reservation>listReservations;
    public ListReservations(){}

    public ListReservations(List<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public List<Reservation> getListReservations() {
        return listReservations;
    }

    public void setListReservations(List<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public void viewDataList(){
        for (Reservation reservation:listReservations){
            System.out.println(reservation.toString());
        }
    }
}

