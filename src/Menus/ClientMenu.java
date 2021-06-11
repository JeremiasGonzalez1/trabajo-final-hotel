package Menus;

import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    public int menuChangeProfile(){
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

    public Client switchMenuChangeProfile(int option, Client client){
        Scanner scanner = new Scanner(System.in);

        String keyInput;

        switch (option){
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
        }

        return client;
    }

    public int optionsMenu() {
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

    public void switchOptionsMenu(int option, Client client, List<Reservation> reservationList, List<Room> roomList, List <Client> clientList, String path){
        int i = clientList.indexOf(client);
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        Reservation reservation = new Reservation();
        DataFile dataFile = new DataFile();
        int optionAux = 0;
        switch(option){
            case 1:
                reservation.dataReservation(roomList, reservationList, client.getUsername());
                break;
            case 2:
                System.out.println(client.toString());
                break;
            case 3:
                optionAux = menuChangeProfile();
                if(optionAux == 1){
                    System.out.println("SU PERFIL SIN CAMBIOS : "+ client.toString());
                    client = switchMenuChangeProfile(optionAux, client);
                    System.out.println("SU PERFIL CON CAMBIOS : " + client.toString());
                    System.out.println("DESEA APLICAR LOS CAMBIOS?");
                    System.out.println("1 - SI");
                    System.out.println("0 - NO");
                    keyInput = scanner.nextLine();
                    if(keyInput.equals("1")){
                        clientList.set(i, client);
                        dataFile.saveOnFile(clientList, path);
                    }
                }
        }
    }
}
