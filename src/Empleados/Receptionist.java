package Empleados;

import Interaction.Check;
import Interaction.Client;
import Interaction.Reservation;
import UtilitiesFiles.DataFile;
import rooms.Room;

import java.util.Date;
import java.util.List;

public class Receptionist extends Employee {

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
}
