package Menus;

import Empleados.Employee;
import Interaction.Client;

import java.util.Scanner;

public class AdminMenu {
    public int optionsMenu() {
        int option = 0;

        return option;
    }

    ;

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
        System.out.println("7 - CAMBIAR ESTADO DE LA RESERVA");
        System.out.println("0 - SALIR");
        keyInput = scanner.nextLine();

        option = Integer.parseInt(keyInput);

        return option;
    }

    public Client switchChangeDataClient(int option, Client client) {
        String keyInput;
        Scanner scanner = new Scanner(System.in);

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
                System.out.println("CAMBIAR ESTADO DE LA RESERVA : ");
                keyInput = scanner.nextLine();
                client.setReservation(Boolean.parseBoolean(keyInput));
                break;
        }

        return client;
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
