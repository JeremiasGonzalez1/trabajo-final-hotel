package Empleados;

import Interaction.Check;
import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;
import rooms.RoomStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Receptionist extends Employee {

    public Receptionist() {
    }

    public Receptionist(String username, String password, String turn, double salary) {
        super(username, password, turn, salary);
    }

    public Receptionist(Employee padre) {
        this.setAdmin(padre.getAdmin());
        this.setPassword(padre.getPassword());
        this.setSalary(padre.getSalary());
        this.setUsername(padre.getUsername());
        this.setTurn(padre.getTurn());
    }

    public boolean createCheckOnReservation(List<Reservation> reservationList, List<Client> clientList, List<Room> roomList, List<Check> checkList, String username, String checkPath, String roomPath) {
        Check check = new Check();
        check.setClient(null);
        boolean flag = false;
        for (Client client : clientList) {
            if (client.getUsername().equals(username)) {
                check.setClient(client);
                LocalDate date = LocalDate.now();
                check.setDateIn(date.toString());
            }
        }
        if (check.getClient() != null) {
            if (check.viewReservations(reservationList)) {
                int index = 0;
                for (Room room : roomList) {
                    if (check.getIdRoom() == room.getId()) {
                        room.setRoomStatus(RoomStatus.OCUPADA);
                        roomList.set(index, room);
                    }
                    index++;
                }
                DataFile dataFile = new DataFile();
                checkList.add(check);
                dataFile.saveOnFile(checkList, checkPath);
                dataFile.saveOnFile(roomList, roomPath);
                flag = true;
            } else {
                System.out.println("EL CLIENTE NO CUENTA CON UNA RESERVACION PARA EL DIA DE HOY");
            }
        }
        return flag;
    }

    public void checkOut(List<Check> checkList, String checkPath) {
        int numberRoom = 0, size = checkList.size(), i = 0;
        String usernameAux;
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        System.out.println("INGRESE NUMERO DE HABITACION");
        numberRoom = Integer.parseInt(scanner.nextLine());
        System.out.println("INGRESE USERNAME DEL CLIENTE");
        usernameAux = scanner.nextLine();
        DataFile dataFile = new DataFile();
        while (i < size) {
            if (numberRoom == checkList.get(i).getIdRoom() && usernameAux.equals(checkList.get(i).getClient().getUsername())) {
                checkList.get(i).setDateOut(date.toString());
            }
            i++;
        }
        dataFile.saveOnFile(checkList, checkPath);
    }

    public void createReservationEmployee(List<Reservation> reservationList, List<Room> roomList, List<Client> clientList) {
        Client client = new Client();
        client = this.searchClient(clientList);
        if (client != null) {
            Reservation reservation = new Reservation();
            reservation.dataReservation(roomList, reservationList, client.getUsername());
        }
    }

    public void seeAvailableRooms(List<Room> roomList) {
        for (Room aux : roomList) {
            if (aux.getRoomStatus().equals(RoomStatus.DISPONIBLE)) {
                System.out.println(aux.toString());
            }
        }
    }

    public Client searchClient(List<Client> clientList) {
        Scanner scanner = new Scanner(System.in);
        String usernameClient;
        Client client = new Client();
        int flag = 0;
        int flag2 = 0;
        do {
            System.out.println("INGRESE USUARIO DEL CLIENTE");
            usernameClient = scanner.nextLine();
            for (Client aux : clientList) {
                if (aux.getUsername().equals(usernameClient)) {
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
            } else {
                System.out.println(client.toString());
            }
        } while (flag != 1 && flag2 == 0);

        return client;
    }
}