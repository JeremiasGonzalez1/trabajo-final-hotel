package Menus;

import Empleados.Admin;
import Empleados.Employee;
import Empleados.Receptionist;
import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public int optionsMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        String keyInput;

        System.out.println("1 - VER TODOS LOS CLIENTES");
        System.out.println("2 - VER TODOS LOS EMPLEADOS");
        System.out.println("3 - DAR DE ALTA O DE BAJA A UN CLIENTE");
        System.out.println("4 - DAR DE ATA O DE BAJA A TODOS LOS CLIENTES");
        System.out.println("5 - VER TODAS LAS HABITACIONES");
        System.out.println("6 - VER TODAS LAS RESERVAS");
        System.out.println("7 - MODIFICAR UN CLIENTE");
        System.out.println("8 - MODIFICAR UN EMPLEADO");
        System.out.println("9 - CREAR UN CLIENTE");
        System.out.println("10 - CREAR UN EMPLEADO");
        System.out.println("11- CHECK IN");
        System.out.println("12 - CHECK OUT");
        System.out.println("0 - SALIR");

        keyInput = scanner.nextLine();
        option = Integer.parseInt(keyInput);

        return option;
    }

    public void switchOptionMenuAdmin(Admin admin, List<Client> clientList, List<Reservation> reservationList, List<Employee> employeeList, List<Room> roomList, String clientPath, String reservationPath, String roomPath, String employeePath ){
        int option = 0;
        do {
            option = optionsMenu();
            Scanner scanner = new Scanner(System.in);
            String keyInput;

            switch (option) {
                case 1:
                    admin.seeAllUsers(clientList);
                    break;
                case 2:
                    admin.seeAllUsers(employeeList);
                    break;
                case 3:
                    admin.activeASelectClient(clientList, clientPath);
                    break;
                case 4:
                    admin.activeAllClients(clientList, clientPath);
                    break;
                case 5:
                    admin.seeAllUsers(roomList);
                    break;
                case 6:
                    admin.seeAllUsers(reservationList);
                    break;
                case 7:
                    admin.modifyClient(clientList, reservationList, clientPath);
                    break;
                case 8:
                    admin.modifyEmployee(employeeList, employeePath);
                    break;
                case 9:
                    admin.registerClient(clientList, clientPath);
                    break;
                case 10:
                    admin.registerReceptionist(employeeList, employeePath);
                    break;
            }
        }while(option!= 0);
    }

    public int changeDataClient() {
        int option = 0;
        String keyInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - CAMBIAR NOMBRE");
        System.out.println("2 - CAMBIAR TELEFONO");
        System.out.println("3 - CAMBIAR DIRECCION");
        System.out.println("4 - CAMBIAR USERNAME");
        System.out.println("5 - CAMBIAR CONTRASEÑA");
        System.out.println("6 - CAMBIAR DNI");
        System.out.println("7 - DAR DE BAJA LA CUENTA");
        System.out.println("8 - ELIMINAR RESERVAS DEL CLIENTE");
        System.out.println("0 - SALIR");
        keyInput = scanner.nextLine();

        option = Integer.parseInt(keyInput);

        return option;
    }

    public void switchChangeDataClient(Client client, List<Reservation> reservationList, List<Client> clientList, String path) {
        Scanner scanner = new Scanner(System.in);
        int option = changeDataClient();
        String keyInput;
        DataFile dataFile = new DataFile();
        switch (option) {
            case 1:
                System.out.println("INGRESE NUEVO NOMBRE : ");
                keyInput = scanner.nextLine();
                client.setName(keyInput);
                break;
            case 2:
                System.out.println("INGRESE NUEVO NUMERO DE TELEFONO : ");
                keyInput = scanner.nextLine();
                client.setPhone(keyInput);
                break;
            case 3:
                System.out.println("INGRESE NUEVA DIRECCION : ");
                keyInput = scanner.nextLine();
                client.setAdress(keyInput);
                break;
            case 4:
                System.out.println("INGRESE NUEVA USERNAME : ");
                keyInput = scanner.nextLine();
                client.setUsername(keyInput);
                break;
            case 5:
                System.out.println("INGRESE NUEVA CONTRASEÑA : ");
                keyInput = scanner.nextLine();
                client.setPassword(keyInput);
                break;
            case 6:
                System.out.println("INGRESE NUEVO DNI : ");
                keyInput = scanner.nextLine();
                client.setId(keyInput);
                break;
            case 7:
                System.out.println("SEGURO QUE QUIERE DAR DE BAJA LA CUENTA?");
                System.out.println("1 - SI");
                System.out.println("0 - NO");
                keyInput = scanner.nextLine();
                if (keyInput.equals("1")) {
                    client.setActive(false);
                }
                break;
            case 8:
                System.out.println("SEGURO QUE QUIERE ELEMINAR LAS RESERVAS DE ESTE CLIENTE?");
                System.out.println("1 - SI");
                System.out.println("0 - NO");
                keyInput = scanner.nextLine();
                if (keyInput.equals("1")) {
                    client.setReservation(false);
                }
                List<Reservation> delete = new ArrayList<>();
                for (Reservation aux : reservationList) {
                    if (aux.getUsernameClient().equals(client.getUsername())) {
                        delete.add(aux);
                    }
                }
                for (Reservation aux : delete) {
                    if (reservationList.contains(aux)) {
                        reservationList.remove(aux);
                    }
                }
        }

       dataFile.saveOnFile(clientList, path);
    }

    public int changeDataEmployee() {
        String keyInput;
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("1 - CAMBIAR USERNAME\n");
        System.out.println("2 - CAMBIAR CONTRASEÑA\n");
        System.out.println("3 - CAMBIAR TURNO\n");
        System.out.println("4 - CAMBIAR CARGO\n");
        System.out.println("5 - CAMBIAR SALARIO\n");
        System.out.println("0 - SALIR\n");

        keyInput = scanner.nextLine();

        option = Integer.parseInt(keyInput);

        return option;
    }

    public Employee switchChangeDataEmployee(int option, Employee aux) {
        String keyInput;
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("INGRESE NUEVO USERNAME: ");
                keyInput = scanner.nextLine();
                aux.setUsername(keyInput);
                break;
            case 2:
                System.out.println("INGRESE NUEVA CONTRASEÑA: ");
                keyInput = scanner.nextLine();
                aux.setPassword(keyInput);
                break;
            case 3:
                System.out.println("INGRESE NUEVO TURNO: ");
                keyInput = scanner.nextLine();
                aux.setTurn(keyInput);
                break;
            case 4:
                System.out.println("INGRESE NUEVO CARGO: ");
                keyInput = scanner.nextLine();
                aux.setAdmin(Boolean.parseBoolean(keyInput));
                break;
            case 5:
                System.out.println("INGRESE NUEVO SALARIO: ");
                keyInput = scanner.nextLine();
                aux.setSalary(Double.parseDouble(keyInput));
                break;

        }

        return aux;
    }
}
