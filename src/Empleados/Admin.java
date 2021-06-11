package Empleados;

import Interaction.Client;
import Menus.AdminMenu;
import UtilitiesFiles.DataFile;

import java.util.List;
import java.util.Scanner;

public class Admin extends Employee {

    public Admin() {
    }

    public Admin(String username, String password, String turn, double salary) {
        super(username, password, turn, salary);
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


    public void modifyClient(List<Client> clientList) {
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
            while(i<sizeList && !flag){
                if(keyInput.equals(clientList.get(i).getId())){
                    client = clientList.get(i);
                    flag = true;
                }
                i++;
            }

            if(flag){
                i--;
                option = menu.changeDataClient();

                client = menu.switchChangeDataClient(option, client);

                System.out.println("CLIENTE SIN CAMBIOS : " + clientList.get(i).toString());
                System.out.println("CLIENTE CON CAMBIOS : " + client.toString());
                System.out.println("DESEA APLICAR LOS CAMIOS?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                keyInput = scanner.nextLine();
                if(keyInput.equals("1")){
                    clientList.set(i, client);
                }
            }else
            {
                System.out.println("EL CLIENTE NO SE ENCONTRÓ");
                System.out.println("DESEA BUSCAR OTRA VEZ?");
                System.out.println("1 - SI");
                System.out.println("2 - NO");
                keyInput = scanner.nextLine();
                if(keyInput.equals("1")){
                    flag2 = true;
                }
            }
        } while (flag2);
    }

    public void modifyEmployee(List<Employee> employeeList) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
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
}
