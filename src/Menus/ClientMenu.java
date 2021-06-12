package Menus;

import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    public int menuChangeProfile() {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("que campo desea modificar?");
        System.out.println("1 - NOMBRE \n" +
                "2 - TELEFONO\n" +
                "3 - DIRECCION\n" +
                "4 - USUARIO \n" +
                "5 - PASSWORD \n" +
                "6 - DNI\n" +
                "7 - DAR DE BAJA LA CUENTA\n" +
                "0 - SALIR");
        keyInput = scanner.nextLine();
        int aux = Integer.parseInt(keyInput);

        return aux;
    }


    public int optionsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - RESERVAR");
        System.out.println("2 - MIRAR PERFIL");
        System.out.println("3 - MODIFICAR PERFIL");
        System.out.println("4 - MIRAR RESERVAS");
        System.out.println("0 - PARA SALIR");
        String keyInput;
        keyInput = scanner.nextLine();
        int option = Integer.parseInt(keyInput);

        return option;
    }

    public void switchOptionsMenu(Client client, List<Reservation> reservationList, List<Room> roomList, List<Client> clientList, String path) {
        int i = 0;
        int size=clientList.size();
        boolean flag=false;
        while (i<size && !flag){
            if(clientList.get(i).getUsername().equals(client.getUsername())){
                flag=true;
            }
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        Reservation reservation = new Reservation();
        DataFile dataFile = new DataFile();
        Client clientAux = new Client();
        int option = 0;
        if(i<size) {
            do {
                option = optionsMenu();
                switch (option) {
                    case 1:
                        reservation.dataReservation(roomList, reservationList, client.getUsername());
                        break;
                    case 2:
                        client.seeProfile();
                        break;
                    case 3:
                        clientAux = client;
                        client.changeProfile(clientList);
                        System.out.println("SU PERFIL CON CAMBIOS : " + client.toString());
                        System.out.println("DESEA APLICAR LOS CAMBIOS?");
                        System.out.println("1 - SI");
                        System.out.println("0 - NO");
                        keyInput = scanner.nextLine();
                        i--;
                        if (keyInput.equals("1")) {
                            clientList.set(i, client);
                            dataFile.saveOnFile(clientList, path);
                        } else {
                            client = clientAux;
                        }
                        break;
                    case 4:
                        client.seeReservations(reservationList);
                        break;
                }
            } while (option != 0 && client.isActive());
        }else{
            System.out.println("OCURRIO UN ERROR");
        }

    }

    public int secondMenuClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - REGISTRARSE");
        System.out.println("2 - LOGEARSE");
        System.out.println("0 - SALIR");

        return Integer.parseInt(scanner.nextLine());
    }

    public boolean secondSwitchMenuClient(List<Client> clientList, String path, Client client) {
        int option = 0;
        boolean flag = false;
        do {
            option = secondMenuClient();
            switch (option) {
                case 1:
                    client.createNewClient(clientList, path);
                    break;
                case 2:
                    flag = client.login(clientList);
                    break;
            }
        } while (option != 0 && !flag);

        return flag;
    }
}
