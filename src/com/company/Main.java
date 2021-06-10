package com.company;

import Empleados.Admin;
import Empleados.Employee;
import Empleados.Receptionist;
import Interaction.Client;
import Interaction.Reservation;
import Menus.AdminMenu;
import Menus.ClientMenu;
import Menus.MainMenus;
import Menus.ReceptionistMenu;
import UtilitiesFiles.DataFile;
import rooms.Room;
import Sign.Sign;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ///VARIABLES
        ///V.BOOLEANS
        boolean clientBoolean = false;
        boolean employeeBoolean = false;
        boolean receptionistBoolean = false;
        ///V.TIPOS DE DATOS
        Client client = new Client();
        Employee employee = new Employee();
        Admin admin = new Admin();
        Receptionist receptionist = new Receptionist();
        Sign sign = new Sign();
        Reservation reservation=new Reservation();
        ///V.MENU
        MainMenus mainMenus = new MainMenus();
        ClientMenu clientMenu = new ClientMenu();
        AdminMenu adminMenu = new AdminMenu();
        ReceptionistMenu receptionistMenu = new ReceptionistMenu();
        ///V.OPTIONS
        int menuOption = 0;
        int clientOption = 0;
        int receptionistOption = 0;
        ///DATAFILE
        DataFile dataFile = new DataFile();
        ///PATHS
        String nameFileRoom = "Rooms.json";
        String nameFileEmployee = "employee.json";
        String nameFileSign = "sign.json";
        String nameFileReservation = "reservas.json";
        String nameFileClient ="Client.json";
        ///LISTAS
        List<Room> roomList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        List<Sign> signList = new ArrayList<>();
        List<Client> clientList = new ArrayList<>();
        ///CARGAR LISTAS
        roomList = dataFile.readLists(nameFileRoom, Room.class);
        employeeList = dataFile.readLists(nameFileEmployee, Employee.class);
        reservationList = dataFile.readLists(nameFileReservation, Reservation.class);
        signList = dataFile.readLists(nameFileSign, Sign.class);

        reservation.dataReservation(roomList,reservationList, "pepe");

        ///SWITCH PRINCIPAL
//        menuOption = mainMenus.mainMenu();
//        switch (menuOption){
//            case 1:
//                clientBoolean = client.login(clientList);
//                if(clientBoolean){
//                    clientOption = clientMenu.optionsMenu();
//                }
//                break;
//            case 2:
//                employeeBoolean = employee.login(employeeList);
//                if(employeeBoolean){
//                    if(employee.getAdmin()){
//                        if(employee instanceof Admin){
//                            admin = (Admin) employee;
//
//                            adminMenu.optionsMenu();
//                        }
//
//                    }else
//                    {
//                        if(employee instanceof Receptionist){
//                            receptionist = (Receptionist) employee;
//                        }
//
//                        receptionistOption = receptionistMenu.initialRecepcionistMenu();
//                        switch (receptionistOption){
//                            case 1:
//                                receptionistBoolean = sign.signIn(receptionist.getUsername());
//                                if(receptionistBoolean){
//                                    receptionistMenu.principalRecepcionistMenu();
//                                }
//                                break;
//                            case 2:
//                                sign.seeSigns(signList, receptionist.getUsername());
//                                break;
//                        }
//
//                    }
//                }
//        }

//        Sign sign = new Sign();
//        Employee empleado1 = new Employee("pedro ", "1234", "Mañana", 45000);
//        sign.signIn(empleado1.getUsername());
//
//        sign.signOut(signList);
//
//        signList = data.readLists("sign.json", Sign.class);
//
//        System.out.println(signList.toString());
//
//        System.out.println("\n");
//
//        sign.seeSigns(signList, empleado1.getUsername());
//        Client client=new Client();
//        client.registration();
//        System.out.println(client.toString());
//        client.loginAccount();
        //Employee empleado = new Employee("maxi", "1234", "Tarde", 45000);

        //empleado.signIn();

//        empleado.signOut();

        //Employee empleado2 = new Employee("pedro ", "1234", "Tarde", 45000);

        // empleado2.signIn();


//        List<Room> roomList = new ArrayList<>();
//
//        Room room2 = new Room(2,1,true);
//        Room room3 = new Room(1,2,true);
//        Room room4 = new Room(3,3,true);
//        Room room5 = new Room(2,4,true);
//        Room room6 = new Room(1,5,true);
//        Room room7 = new Room(3,6,true);
//        Room room8 = new Room(2,7,true);
//        Room room9 = new Room(1,8,true);
//        Room room10 = new Room(3,9,true);
//        Room room11 = new Room(2,10,true);
//        Room room12 = new Room(1, 11,true);
//        Room room13 = new Room(3,12,true);
//        Room room14 = new Room(2, 13,true);
//        Room room16 = new Room(1, 15,true);
//        Room room17 = new Room(3, 16,true);
//        Room room18 = new Room(2, 17,true);
//        Room room19 = new Room(1,  18,true);
//        Room room20 = new Room(3, 19,true);
//        Room room21 = new Room(2, 20,true);
//        Room room22 = new Room(1, 21,true);
//        Room room23 = new Room(3, 22,true);
//        Room room24 = new Room(2, 23,true);
//        Room room25 = new Room(1, 24,true);
//        Room room26 = new Room(3, 25,true);
//        Room room27 = new Room(2, 26,true);
//        Room room28 = new Room(1, 27,true);
//        Room room29 = new Room(3, 28,true);
//        Room room30 = new Room(2, 29,true);
//        Room room31 = new Room(1, 30,true);
//        Room room32 = new Room(3,31,true);
//        Room room33 = new Room(2, 32,true);
//
//
//        roomList.add(room2);
//        roomList.add(room3);
//        roomList.add(room4);
//        roomList.add(room5);
//        roomList.add(room6);
//        roomList.add(room7);
//        roomList.add(room8);
//        roomList.add(room9);
//        roomList.add(room10);
//        roomList.add(room11);
//        roomList.add(room12);
//        roomList.add(room13);
//        roomList.add(room14);
//        roomList.add(room16);
//        roomList.add(room17);
//        roomList.add(room18);
//        roomList.add(room19);
//        roomList.add(room20);
//        roomList.add(room21);
//        roomList.add(room22);
//        roomList.add(room23);
//        roomList.add(room24);
//        roomList.add(room25);
//        roomList.add(room26);
//        roomList.add(room27);
//        roomList.add(room28);
//        roomList.add(room29);
//        roomList.add(room30);
//        roomList.add(room31);
//        roomList.add(room32);
//        roomList.add(room33);
//        DataFile dataFile = new DataFile();
////
//////
////        Reservation reservation =new Reservation();
////        reservation.dataReservation(listaDeHabitaciones, reservationList );
//        reservationList = dataFile.readLists("reservas.json", Reservation.class);
//
//        System.out.println(reservationList.toString());
    }
}
