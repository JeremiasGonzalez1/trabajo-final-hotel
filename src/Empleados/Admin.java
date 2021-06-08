package Empleados;

import UtilitiesFiles.DataFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Employee{

    public Admin(){};
    public Admin(String username, String password, String turn, double salary) {
        super(username, password, turn, salary);
    }

    public void registerReceptionist(List <Employee> employeeList, String path){

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

    private boolean isAdmin(){
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        boolean admin = false;
        keyInput = scanner.nextLine();
        admin = Boolean.parseBoolean(keyInput);
        return admin;
    }

}
