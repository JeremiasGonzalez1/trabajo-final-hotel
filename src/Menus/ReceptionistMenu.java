package Menus;

import Empleados.Receptionist;
import Interaction.Check;
import Interaction.Client;
import Interaction.Reservation;
import Sign.Sign;
import rooms.Room;

import java.util.List;
import java.util.Scanner;

public class ReceptionistMenu {
    public int initialRecepcionistMenu() {
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

    public void switchInitialReceptionistMenu(Receptionist receptionist, List<Check> checkList, String nameFileCheck, List<Reservation> reservationList,
                                              List<Client> clientList, List<Room> roomList, String nameFileRoom,
                                              List<Sign> signList)
    {
        int option = 0;
        Sign sign = new Sign();
        boolean flag = false;
        do{
            option = initialRecepcionistMenu();
            switch (option){
                case 1:
                    flag = sign.signIn(receptionist.getUsername());
                    if(flag){
                        switchPrincipalReceptionistMenu(receptionist, checkList,nameFileCheck,reservationList,clientList,roomList,nameFileRoom, signList, sign);
                    }
                    break;
                case 2:
                    sign.seeSigns(signList, receptionist.getUsername());
                    break;
            }
        }while (option != 0);

    }

    public int principalReceptionistMenu() {
        String keyInput;
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("1 - CHECK IN\n");
        System.out.println("2 - CHECK OUT\n");
        System.out.println("3 - BUSCAR UN CLIENTE\n");
        System.out.println("4 - HACER UNA RESERVA\n");
        System.out.println("5 - VER HABITACIONES DISPONIBLES\n");
        System.out.println("6 - VER FICHADAS");
        System.out.println("7 - FICHAR SALIDA\n");
        keyInput = scanner.nextLine();
        option = Integer.parseInt(keyInput);
        return option;
    }

    public void switchPrincipalReceptionistMenu(Receptionist receptionist, List<Check> checkList, String nameFileCheck, List<Reservation> reservationList,
                                                 List<Client> clientList, List<Room> roomList, String nameFileRoom,
                                                List<Sign> signList, Sign sign) {
        int option = 0;
        boolean flag = false;
        String usernameAux, keyInput;
        Scanner scanner = new Scanner(System.in);
        do {
            option = principalReceptionistMenu();
            switch (option) {
                case 1:
                    System.out.println("INGRESE USERNAME DEL CLIENTE");
                    usernameAux = scanner.nextLine();
                    flag = receptionist.createCheckOnReservation(reservationList, clientList, roomList, checkList, usernameAux, nameFileCheck, nameFileRoom);
                    if (!flag) {
                        System.out.println("DESEA CREARLA?");
                        System.out.println("1 - SI");
                        System.out.println("0 - NO");
                        keyInput = scanner.nextLine();
                        if (keyInput.equals("1")) {
                            receptionist.createReservationEmployee(reservationList, roomList, clientList);
                            receptionist.createCheckOnReservation(reservationList, clientList, roomList, checkList, usernameAux, nameFileCheck, nameFileRoom);
                        }
                    }
                    break;
                case 2:
                    receptionist.checkOut(checkList, nameFileCheck);
                    break;
                case 3:
                    receptionist.searchClient(clientList);
                    break;
                case 4:
                    receptionist.createReservationEmployee(reservationList, roomList, clientList);
                    break;
                case 5:
                    receptionist.seeAvailableRooms(roomList);
                    break;
                case 6:
                    sign.seeSigns(signList, receptionist.getUsername());
                    break;
                case 7:
                    sign.signOut(signList);
            }

        } while (option != 0);


    }
}
