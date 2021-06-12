package Menus;

import Empleados.Admin;
import Empleados.Employee;
import Empleados.Receptionist;
import Interaction.Check;
import Interaction.Client;
import Interaction.Reservation;
import Sign.Sign;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenus {
    public int mainMenu() {
        int option;
        String keyString;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - INGRESAR COMO CLIENTE\n");
        System.out.println("2 - INGRESAR COMO EMPLEADO\n");
        System.out.println("0 - PARA SALIR");
        keyString = scanner.nextLine();
        option = Integer.parseInt(keyString);

        return option;
    }

    public void switchMainMenu() {

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
        Reservation reservation = new Reservation();
        ///V.MENU
        MainMenus mainMenus = new MainMenus();
        ClientMenu clientMenu = new ClientMenu();
        AdminMenu adminMenu = new AdminMenu();
        ReceptionistMenu receptionistMenu = new ReceptionistMenu();
        ///DATAFILE
        DataFile dataFile = new DataFile();
        ///PATHS
        String nameFileRoom = "Rooms.json";
        String nameFileEmployee = "Employee.json";
        String nameFileSign = "Sign.json";
        String nameFileReservation = "Reservas.json";
        String nameFileClient = "Client.json";
        String nameFileCheck= "Check.json";
        ///LISTAS
        List<Room> roomList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Reservation> reservationList = new ArrayList<>();
        List<Sign> signList = new ArrayList<>();
        List<Client> clientList = new ArrayList<>();
        List<Check>checkList=new ArrayList<>();
        ///CARGAR LISTAS
        roomList = dataFile.readLists(nameFileRoom, Room.class);
        employeeList = dataFile.readLists(nameFileEmployee, Employee.class);
        reservationList = dataFile.readLists(nameFileReservation, Reservation.class);
        signList = dataFile.readLists(nameFileSign, Sign.class);
        clientList=dataFile.readLists(nameFileClient, Client.class);
        checkList=dataFile.readLists(nameFileCheck, Check.class);
        int generalOption = 0;
        do {
            generalOption=mainMenu();
            switch (generalOption) {
                case 1:
                    clientBoolean = clientMenu.secondSwitchMenuClient(clientList, nameFileClient, client);
                    if (clientBoolean) {
                        clientMenu.switchOptionsMenu(client, reservationList, roomList, clientList, nameFileClient);
                    }
                    break;
                case 2:
                    employeeBoolean = employee.login(employeeList);
                    if (employeeBoolean) {
                        if (employee.getAdmin()) {
                            admin = new Admin(employee);
                            adminMenu.switchOptionMenuAdmin(admin, clientList, reservationList, employeeList, roomList, nameFileClient, nameFileReservation, nameFileRoom, nameFileEmployee, checkList, nameFileCheck);
                        } else {
                                receptionist = new Receptionist(employee);
                                receptionistMenu.switchInitialReceptionistMenu(receptionist, checkList,nameFileCheck,reservationList,clientList,roomList,nameFileRoom, signList);
                        }
                    }
                    break;

            }
        }while (generalOption!=0);

    }
}
