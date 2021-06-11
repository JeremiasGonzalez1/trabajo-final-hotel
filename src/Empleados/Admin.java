package Empleados;

import Interaction.Client;
import Interaction.Reservation;
import Menus.AdminMenu;
import UtilitiesFiles.DataFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Receptionist {

    public Admin() {
    }

    public Admin(String username, String password, String turn, double salary) {
        super(username, password, turn, salary);
    }
    public Admin(Employee padre){
        this.setAdmin(padre.getAdmin());
        this.setPassword(padre.getPassword());
        this.setSalary(padre.getSalary());
        this.setUsername(padre.getUsername());
        this.setTurn(padre.getTurn());
    }

    public void registerReceptionist(List<Employee> employeeList, String path) {

        DataFile dataFile = new DataFile();
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        Employee employee = new Employee();
        System.out.println("Ingrese Username del empleado");
        employee.setUsername(scanner.nextLine());
        System.out.println("Ingrese Contraseña del empleado");
        employee.setPassword(scanner.nextLine());
        System.out.println("Ingrese Salario del empleado");
        keyInput = scanner.nextLine();
        double aux = Double.parseDouble(keyInput);
        employee.setSalary(aux);
        System.out.println("Ingrese turno del empleado");
        employee.setTurn(scanner.nextLine());
        System.out.println("Ingrese puesto");
        employee.setAdmin(isAdmin());
        System.out.println(employee.toString());
        employeeList.add(employee);

        dataFile.saveOnFile(employeeList, path);
    }

    private boolean isAdmin() {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        boolean admin = false;
        keyInput = scanner.nextLine();
        admin = Boolean.parseBoolean(keyInput);
        return admin;
    }

    public <T> void seeAllUsers(List<T> list) {
        System.out.println(list.toString());
    }


    public void modifyClient(List<Client> clientList, List<Reservation> reservationList, String path) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        Client client = null;
        int sizeList = clientList.size();
        int i = 0, option = 0;
        AdminMenu menu = new AdminMenu();
        boolean flag = false, flag2 = false;

        do {
            System.out.println("INGRESE DNI DEL CLIENTE A MODIFICAR : ");
            keyInput = scanner.nextLine();
            while (i < sizeList && !flag) {
                if (keyInput.equals(clientList.get(i).getId())) {
                    client = clientList.get(i);
                    flag = true;
                }
                i++;
            }

            if (flag) {
                i--;
                option = menu.changeDataClient();

                menu.switchChangeDataClient(client,reservationList, clientList, path);

                System.out.println("CLIENTE SIN CAMBIOS : " + clientList.get(i).toString());
                System.out.println("CLIENTE CON CAMBIOS : " + client.toString());
                System.out.println("DESEA APLICAR LOS CAMIOS?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                keyInput = scanner.nextLine();
                if (keyInput.equals("1")) {
                    clientList.set(i, client);
                }
            } else {
                System.out.println("EL CLIENTE NO SE ENCONTRÓ");
                System.out.println("DESEA BUSCAR OTRA VEZ?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                keyInput = scanner.nextLine();
                if (keyInput.equals("1")) {
                    flag2 = true;
                }
            }
        } while (flag2);
    }

    public void modifyEmployee(List<Employee> employeeList, String path) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        DataFile dataFile = new DataFile();
        Employee employee = null;
        int sizeList = employeeList.size();
        int i = 0, option = 0;
        AdminMenu menu = new AdminMenu();
        boolean flag = false, flag2 = false;
        do {
            System.out.println("INGRESE USERNAME DEL EMPLEADO A MODIFICAR : ");
            keyInput = scanner.nextLine();
            while (i < sizeList && !flag) {

                if (employeeList.get(i).getUsername().equals(keyInput)) {
                    employee = employeeList.get(i);
                    flag = true;
                }
                i++;
            }

            if (flag) {
                option = menu.changeDataEmployee();
                employee = menu.switchChangeDataEmployee(option, employee);
                System.out.println("EMPLEADO SIN CAMBIOS : " + employeeList.get(i--).toString());
                System.out.println("EMPLEADO CON CAMBIOS : " + employee.toString());
                System.out.println("DESEA APLICAR LOS CAMBIOS?");
                System.out.println("1 - SI");
                System.out.println("0 - NO");
                keyInput = scanner.nextLine();
                if (keyInput.equals("1")) {
                    employeeList.set(i, employee);
                    dataFile.saveOnFile(employeeList, path);
                }
            } else {
                System.out.println("NO SE ENCONTRÓ AL EMPLEADO\n");
                System.out.println("DESEA REPETIR LA OPERACION?\n");
                System.out.println("1 - SI");
                System.out.println("0 - NO");
                keyInput = scanner.nextLine();
                flag2 = Boolean.parseBoolean(keyInput);
            }
        } while (flag2);
    }

    public Employee adminSearchEmployee(List <Employee> employeeList){
        Scanner scanner = new Scanner(System.in);
        String usernameEmployee;
        Employee employee = new Employee();
        int flag = 0;
        int flag2 = 0;
        do {
            System.out.println("INGRESE USUARIO DEL CLIENTE");
            usernameEmployee = scanner.nextLine();
            for (Employee aux : employeeList) {
                if (aux.getUsername().equals(usernameEmployee)) {
                    flag = 1;
                    employee = aux;
                }
            }

            if (flag == 0) {
                System.out.println("EL USUARIO INGRESADO NO COINCIDE CON NUESTROS DATOS, DESEA REINTENTAR? \n" +
                        "1 PARA SI \n" +
                        "0 PARA NO");
                String keyInput;
                keyInput = scanner.nextLine();
                flag2 = Integer.parseInt(keyInput);
            }
        } while (flag != 1 && flag2 == 0);

        return employee;
    }
    public void activeAllClients(List<Client> clientList, String path){
        int size = clientList.size();
        int i = 0;
        DataFile dataFile = new DataFile();
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        boolean option = false;
        System.out.println("1 - DESEA DAR DE ALTA A TODOS LOS CLIENTES");
        System.out.println("2 - DESEA DAR DE BAJA A TODOS LOS CLIENTES");
        System.out.println("0 - SALIR");
        keyInput = scanner.nextLine();
        if(keyInput.equals("1")){
            option = true;
        }
        if(!keyInput.equals("0")) {
            while (i < size) {
                clientList.get(i).setActive(option);
            }
            dataFile.saveOnFile(clientList, path);
        }

    }


    public void activeASelectClient(List <Client> clientList, String path){
        Client client = null;
        DataFile dataFile = new DataFile();
        client = super.searchClient(clientList);
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        if(client != null){
            int index = clientList.indexOf(client);
            System.out.println("1 - DESEA DAR DE ALTA");
            System.out.println("2 - DESEA DAR DE BAJA");
            System.out.println("0 - SALIR");
            keyInput = scanner.nextLine();
            if(keyInput.equals("1")){
                client.setActive(true);
            }else if(keyInput.equals("2")){
                client.setActive(false);
            }

            clientList.set(index, client);

            dataFile.saveOnFile(clientList, path);
        }
    }

    public void registerClient(List <Client> clientList, String path) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        DataFile dataFile = new DataFile();
        Client client = new Client();

        System.out.println("INGRESE NOMBRE");
        client.setName(scanner.nextLine());
        System.out.println("INGRESE TELEFONO");
        client.setPhone(scanner.nextLine());
        System.out.println("INGRESE DIRECCION");
        client.setAdress(scanner.nextLine());
        System.out.println("INGRESE USUARIO");
        client.setUsername(scanner.nextLine());
        System.out.println("INGRESE CONTRASEÑA");
        client.setPassword(scanner.nextLine());
        System.out.println("INGRESE DNI");
        client.setPassword(scanner.nextLine());
        System.out.println("DESEA ACTIVAR AHORA AL USUARIO?");
        System.out.println("1 - SI");
        System.out.println("2 - NO");
        keyInput = scanner.nextLine();
        if (keyInput.equals("1")) {
            client.setActive(true);
        }

        System.out.println("CONFIRMAR USUARIO");
        System.out.println("1 - SI");
        System.out.println("1 - NO");
        keyInput = scanner.nextLine();
        if (keyInput.equals("1")) {
            clientList.add(client);
            dataFile.saveOnFile(clientList, path);
        }
    }
}
