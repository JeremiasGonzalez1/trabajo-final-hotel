package Menus;

import java.util.Scanner;

public class MainMenus {
    public int mainMenu(){
        int option;
        String keyString;
        Scanner scanner= new Scanner (System.in);

        System.out.println("1 - INGRESAR COMO CLIENTE\n");
        System.out.println("2 - INGRESAR COMO EMPLEADO\n");
        keyString = scanner.nextLine();
        option = Integer.parseInt(keyString);

        return option;
    }


}
