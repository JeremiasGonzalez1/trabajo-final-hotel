package Menus;

import java.util.Scanner;

public class ReceptionistMenu {
    public int initialRecepcionistMenu(){
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        int option;
        System.out.println("1 - FICHAR\n");
        System.out.println("2 - VER FICHADAS\n");
        System.out.println("0 - SALIR\n");
        keyInput = scanner.nextLine();
        option = Integer.parseInt(keyInput);
        return option;
    }

    public int principalRecepcionistMenu(){
        String keyInput;
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("1 - CHECK IN\n");
        System.out.println("2 - CHECK OUT\n");
        System.out.println("3 - BUSCAR UN CLIENTE\n");
        System.out.println("4 - HACER UNA RESERVA\n");
        System.out.println("5 - VER HABITACIONES DISPONIBLES\n");
        System.out.println("6 - FICHAR SALIDA\n");
        keyInput = scanner.nextLine();
        option = Integer.parseInt(keyInput);
        return option;
    }
}
