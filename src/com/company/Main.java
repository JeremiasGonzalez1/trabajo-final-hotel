package com.company;
import  Interaction.Client;
import Interaction.Reservation;
import Utils.ListReservations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Date date1 = new Date();
        Date date2 = new Date(2021, 12, 14);
        Reservation reservation = new Reservation(date1, date2);
        reservation.saveOnFile();
        List<Reservation>reservations=new ArrayList<>();
        reservations = reservation.readToFile(reservations);
        ListReservations listReservations=new ListReservations(reservations);
        System.out.println("hola");
        listReservations.viewDataList();
    }
}
