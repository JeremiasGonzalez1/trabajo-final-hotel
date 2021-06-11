package Menus;

import Empleados.Admin;
import Empleados.Employee;
import Empleados.Receptionist;
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
        keyString = scanner.nextLine();
        option = Integer.parseInt(keyString);

        return option;
    }

    public void switchMainMenu() {
        int generalOption = mainMenu();
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
        ///V.OPTIONS
        int menuOption = 0;
        int clientOption = 0;
        int adminOption = 0;
        int receptionistOption = 0;
        ///DATAFILE
        DataFile dataFile = new DataFile();
        ///PATHS
        String nameFileRoom = "Rooms.json";
        String nameFileEmployee = "employee.json";
        String nameFileSign = "sign.json";
        String nameFileReservation = "reservas.json";
        String nameFileClient = "Client.json";
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

        switch (generalOption) {
            case 1:
                clientBoolean = client.login(clientList);
                if (clientBoolean) {
                    clientMenu.switchOptionsMenu(client, reservationList, roomList, clientList, nameFileClient);
                }
                break;
            case 2:
                employeeBoolean = employee.login(employeeList);
                if (employeeBoolean) {
                    if (employee.getAdmin()) {
                            admin = new Admin(employee);
                            adminMenu.switchOptionMenuAdmin(admin, clientList, reservationList, employeeList, roomList, nameFileClient, nameFileReservation, nameFileRoom, nameFileEmployee);

                    } else {
                        if (employee instanceof Receptionist) {
                            receptionist = (Receptionist) employee;
                            System.out.println("sdsdsds");

                        }
                    }
                }
                break;

        }
    }
}
