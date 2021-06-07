package Interaction;

import UtilitiesFiles.DataFile;
import interfaces.RoomCheck;
import rooms.Room;

import java.io.File;
import java.util.*;


public class Reservation implements RoomCheck {

    private Date dateAdmission = new Date();
    private Date dateOut = new Date();
    private int numRoom = 0;

    public Reservation() {
        dateAdmission = null;
        dateOut = null;
        numRoom = 0;
    }

    public Reservation(Date dateAdmission, Date dateOut) {
        this.dateAdmission = dateAdmission;
        this.dateOut = dateOut;
        this.numRoom = 0;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    @Override
    public void consultaHabitacion(int numberBed, Date in, Date out, List<Room> roomList, List<Reservation> reservationList) {

        List<Room> bedsList = new ArrayList<>();
        for (Room room : roomList) {
            ///bajo todas las habitaciones que tienen la misma cantidad de camas a un nuevo arreglo
            if (room.getNumberBeds() == numberBed && room.getStatus()) {
                bedsList.add(room);
            }
        }

        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("Desea resevar?");
        keyInput = scanner.nextLine();
        int dato = Integer.parseInt(keyInput);

        if (dato == 1)///Si el scan es true
        {
            System.out.println(bedsList.toString());
            this.selectRoom(bedsList, in, out, reservationList);
        }
    }

    public void dataReservation(List<Room> roomList, List<Reservation> reservationList) {
        this.upDateIn(this);
        this.upDateOut(this);
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("ingrese el numero de camas que esta buscando ");
        keyInput = scanner.nextLine();
        int beds = Integer.parseInt(keyInput);
        this.consultaHabitacion(beds, this.getDateAdmission(), this.getDateOut(), roomList, reservationList);
    }

    //metodo para ingreso de ingreso
    public Reservation upDateIn(Reservation dateIn) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("Coloque mes de ingreso");
        keyInput = scanner.nextLine();
        int mont = Integer.parseInt(keyInput);
        System.out.println("coloque dia de ingreso");
        keyInput = scanner.nextLine();
        int day = Integer.parseInt(keyInput);
        Date date = new Date(2021, mont, day);
        dateIn.setDateAdmission(date);
        return dateIn;
    }

    //metodo para ingresa fecha de egreso
    public Reservation upDateOut(Reservation dateOut) {
        Scanner scanner = new Scanner(System.in);
        String keyImput;
        System.out.println("coloque mes de egreso");
        keyImput = scanner.nextLine();
        int mont = Integer.parseInt(keyImput);
        System.out.println("coloque dia de egreso");
        keyImput = scanner.nextLine();
        int day = Integer.parseInt(keyImput);
        Date date = new Date(2021, mont, day);
        dateOut.setDateOut(date);
        return dateOut;
    }

    private int selectRoom(List<Room> listOfBeds, Date dateIn, Date dateOut, List<Reservation> reservationList) {
        int flag = 0;

        int flag2 = 0;
        do {
            System.out.println("0-volver");
            Scanner scanner = new Scanner(System.in);
            String keyInput;
            keyInput = scanner.nextLine();
            int roomId = Integer.parseInt(keyInput);

            flag2 = 0;
            if (roomId != 0) {
                for (Room room : listOfBeds) {
                    if (room.getId() == roomId) {
                        flag = 1;
                    }
                }

                if (flag == 0) {
                    System.out.println("No se encontro la habitacion desea\n Desea buscar otra habitacion?");
                    ///scan flag2, si pone 1 es porque quiere volver a buscar, si pone 0 es porque no
                    keyInput = scanner.nextLine();
                    flag2 = Integer.parseInt(keyInput);
                } else {
                    this.resevar(roomId, dateIn, dateOut, reservationList);
                }
            }
        } while (flag2 == 1);

        return flag;
    }

    private void resevar(int id, Date in, Date out, List<Reservation> reservationList) {
        String pathReservation = "reservas.json";
        System.out.println("Seguro de que quiere reservar?");
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        keyInput = scanner.nextLine();
        int flag = Integer.parseInt(keyInput);
        if (flag == 1) {
            this.numRoom = id;
            reservationList.add(this);
            DataFile dataFile = new DataFile();
            dataFile.saveOnFile(reservationList, pathReservation);
        }
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "dateAdmission=" + dateAdmission +
                ", dateOut=" + dateOut +
                '}';
    }


}
