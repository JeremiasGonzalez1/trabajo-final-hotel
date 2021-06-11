package Interaction;

import UtilitiesFiles.DataFile;
import interfaces.RoomCheck;
import rooms.Room;
import rooms.RoomStatus;

import java.io.File;
import java.util.*;


public class Reservation implements RoomCheck {

    private Date dateAdmission = new Date();
    private Date dateOut = new Date();
    private int numRoom = 0;
    private String usernameClient = "";

    public Reservation() {
        dateAdmission = null;
        dateOut = null;
        numRoom = 0;
        usernameClient = "";
    }

    public Reservation(Date dateAdmission, Date dateOut, String usernameClient) {
        this.dateAdmission = dateAdmission;
        this.dateOut = dateOut;
        this.numRoom = 0;
        this.usernameClient = usernameClient;
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

    public String getUsernameClient() {
        return usernameClient;
    }

    public void setUsernameClient(String usernameClient) {
        this.usernameClient = usernameClient;
    }

    @Override
    public void consultaHabitacion(int numberBed, Date in, Date out, List<Room> roomList, List<Reservation> reservationList) {

        List<Room> theBestListOfBedsRevolutionsDefinitive = new ArrayList<>();
        List<Room> bedsList = new ArrayList<>();
        for (Room room : roomList) {
            ///bajo todas las habitaciones que tienen la misma cantidad de camas a un nuevo arreglo
            if (room.getNumberBeds() == numberBed) {
                bedsList.add(room);
            }
        }

        for (Reservation rAux : reservationList) {
            if ((out.compareTo(rAux.getDateAdmission())>=0 && out.compareTo(rAux.getDateOut())<= 0) || in.compareTo(rAux.getDateAdmission())>=0 && in.compareTo(rAux.getDateOut())<=0) {
               ///En este if compara si la fecha de salida o la de entrada chocan con las de las reservas
                for (Room room : bedsList) {
                    ///Si entra en el if anterior, lo que tenemos que buscar es la habitacion ocupada.
                    if (room.getId() == rAux.getNumRoom()) {
                        ///Como nos manejamos con la lista de camas, solamente sacamos las camas que estan ocupadas esos dias
                        ///Pero para no quitar directamente, ya que estamos dentro de un for each y podría romper
                        ///Cargamos las habitaciones ocupadas dentro de una lista auxiliar "TheBestListOf... esa"
                        theBestListOfBedsRevolutionsDefinitive.add(room);
                    }
                }
            }
        }

        ///Al tener la lista auxiliar cargada con datos de camas ocupadas
        ///Ahora si ya las podemos borrar de la lista que vamos a seguir utiliziando "bedsList"
        for (Room aux : theBestListOfBedsRevolutionsDefinitive) {
            bedsList.remove(aux);
        }

        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("DESEA RESERVAR? \n" +
                "1-PARA SI\n" +
                "0-PARA NO");
        keyInput = scanner.nextLine();
        int dato = Integer.parseInt(keyInput);
        if (dato == 1)///Si el scan es true
        {
            System.out.println(bedsList.toString());
            this.selectRoom(bedsList, in, out, reservationList);
        }
    }

    public void dataReservation(List<Room> roomList, List<Reservation> reservationList, String usernameClient) {
        this.setUsernameClient(usernameClient);
        this.upDateIn();
        this.upDateOut();
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("CUANTAS CAMAS BUSCA?");
        keyInput = scanner.nextLine();
        int beds = Integer.parseInt(keyInput);
        System.out.println(this.toString());
        this.consultaHabitacion(beds, this.getDateAdmission(), this.getDateOut(), roomList, reservationList);
    }

    //metodo para ingreso de ingreso
    private void upDateIn() {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("COLOQUE MES DE INGRESO");
        keyInput = scanner.nextLine();
        int mont = Integer.parseInt(keyInput);
        System.out.println("COLOQUE DIA DE INGRESO");
        keyInput = scanner.nextLine();
        int day = Integer.parseInt(keyInput);
        Date date = new Date(2021, mont, day);
        this.setDateAdmission(date);
    }

    //metodo para ingresa fecha de egreso
    public void upDateOut() {
        Scanner scanner = new Scanner(System.in);
        String keyImput;
        System.out.println("COLOQUE MES DE EGRESO");
        keyImput = scanner.nextLine();
        int mont = Integer.parseInt(keyImput);
        System.out.println("COLOQUE DIA DE EGRESO");
        keyImput = scanner.nextLine();
        int day = Integer.parseInt(keyImput);
        Date date = new Date(2021, mont, day);
        this.setDateOut(date);
    }

    private int selectRoom(List<Room> listOfBeds, Date dateIn, Date dateOut, List<Reservation> reservationList) {
        int flag = 0;

        int flag2 = 0;
        do {
            System.out.println("SELECCIONE EL ID DE LA HABITACION DESEADA");
            System.out.println("0-VOLVER");
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
                ", numRoom=" + numRoom +
                ", usernameClient='" + usernameClient + '\'' +
                '}';
    }


}
