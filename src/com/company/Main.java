package com.company;
import Empleados.Employee;
import  Interaction.Client;
import Interaction.Reservation;
import Sign.Sign;
import UtilitiesFiles.DataFile;
import Utils.ListReservations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Client client=new Client();
//        client.registration();
//        System.out.println(client.toString());
//        client.loginAccount();
        Employee empleado = new Employee("maxi", "1234", "Tarde", 45000);

//        empleado.signIn();
//
//        empleado.signOut();

        Employee empleado2 = new Employee("pedro ", "1234", "Tarde", 45000);

//        empleado2.signIn();
//
//        empleado2.signOut();

        String nameFileReservation="reservations.json";
        Date date1=new Date();
        Date date2=new Date(2021, 06, 26);

        Reservation reservation=new Reservation(date1, date2);

        DataFile dataFile=new DataFile();
        List<Reservation>reservations=new ArrayList<>();
        dataFile.saveOnFileReservation(reservation, nameFileReservation);

        reservations=dataFile.readOnFile(nameFileReservation);

        ListReservations listReservations=new ListReservations(reservations);
        listReservations.viewDataList();


    }
}
