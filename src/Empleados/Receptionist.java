package Empleados;

import Interaction.Check;
import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Receptionist extends Employee {

    public Receptionist() {
    }

    public Receptionist(String username, String password, String turn, double salary) {
        super(username, password, turn, salary);
    }

    public void createCheckOnReservation(List<Reservation> reservationList, List<Client> clientList, List<Room> roomList, List<Check> checkList, String username, String checkPath, String roomPath) {
        Check check = new Check();
        for (Client client : clientList) {
            if (client.getUsername() == username) {
                check.setClient(client);
                Date date = new Date();
                check.setDate(date);
            }
        }

        if (check.viewReservations(reservationList)) {
            int index = 0;
            for (Room room : roomList) {
                if (check.getIdRoom() == room.getId()) {
                    room.setStatus(false);
                    roomList.set(index, room);
                }
                index++;
            }
            DataFile dataFile = new DataFile();
            checkList.add(check);
            dataFile.saveOnFile(checkList, checkPath);
            dataFile.saveOnFile(roomList, roomPath);
        } else {
            System.out.println("EL CLIENTE NO CUENTA CON UNA RESERVACION PARA EL DIA DE HOY");
        }
    }

    public void createReservationEmployee(List<Reservation> reservationList, List<Room> roomList, List<Client> clientList) {

        Client clien = new Client();
        clien = this.searchClient(clientList);
        if (clien != null) {
            Reservation reservation = new Reservation();
            reservation.dataReservation(roomList, reservationList, clien.getUsername());
        }
    }


    private Client searchClient(List<Client> clientList) {
        Scanner scanner = new Scanner(System.in);
        String usernameClient;
        Client client = new Client();
        int flag = 0;
        int flag2 = 0;
        do {
            System.out.println("INGRESE USUARIO DEL CLIENTE");
            usernameClient = scanner.nextLine();
            for (Client aux : clientList) {
                if (aux.getUsername() == usernameClient) {
                    flag = 1;
                    client = aux;
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

        return client;
    }
}