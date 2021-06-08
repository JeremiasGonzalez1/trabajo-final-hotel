package Menus;

import java.util.Scanner;

public class ClientMenu {
    private int menuChangeProfile(){
        Scanner scanner =new Scanner(System.in);
        String keyInput;
        System.out.println("que campo desea modificar?");
        System.out.println("1-NOMBRE \n" +
                "2-TELEFONO\n" +
                "3-DIRECCION\n" +
                "4-USUARIO \n" +
                "5-PASSWORD \n" +
                "6-DNI");
        keyInput=scanner.nextLine();
        int aux=Integer.parseInt(keyInput);
        return aux;
    }

    private int optionsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- reservas");
        System.out.println("2- Mirar perfil");
        System.out.println("3- Modificar perfil");
        System.out.println("4- Mirar consumos");
        System.out.println("0- Para salir");
        String keyInput;
        keyInput = scanner.nextLine();
        int option = Integer.parseInt(keyInput);

        return option;
    }
}
