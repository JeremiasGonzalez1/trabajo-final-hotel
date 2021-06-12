package Interaction;

import UtilitiesFiles.DataFile;
import interfaces.RoomCheck;
import rooms.Room;

import java.time.LocalDate;
import java.util.*;


public class Reservation implements RoomCheck {

    private String dateAdmission;
    private String dateOut;
    private int numRoom = 0;
    private String usernameClient = "";

    public Reservation() {
        dateAdmission = null;
        dateOut = null;
        numRoom = 0;
        usernameClient = "";
    }

    public Reservation(LocalDate dateAdmission, LocalDate dateOut, String usernameClient) {
        this.dateAdmission = dateAdmission.toString();
        this.dateOut = dateOut.toString();
        this.numRoom = 0;
        this.usernameClient = usernameClient;
    }

    public String getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(String dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
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
    public void consultaHabitacion(int numberBed, LocalDate in, LocalDate out, List<Room> roomList, List<Reservation> reservationList) {

        List<Room> theBestListOfBedsRevolutionsDefinitive = new ArrayList<>();
        List<Room> bedsList = new ArrayList<>();
        for (Room room : roomList) {
            ///bajo todas las habitaciones que tienen la misma cantidad de camas a un nuevo arreglo
            if (room.getNumberBeds() == numberBed) {
                bedsList.add(room);
            }
        }

        for (Reservation rAux : reservationList) {
            LocalDate rAuxAdmission = LocalDate.parse(rAux.getDateAdmission());
            LocalDate rAuxOut = LocalDate.parse(rAux.getDateOut());
            if ((out.compareTo(rAuxAdmission) >= 0 && out.compareTo(rAuxOut) <= 0) ||
                    (in.compareTo(rAuxAdmission) >= 0 && in.compareTo(rAuxOut) <= 0)) {
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
        System.out.println(bedsList.toString());
        this.selectRoom(bedsList, in, out, reservationList);

    }

    public void dataReservation(List<Room> roomList, List<Reservation> reservationList, String usernameClient) {
        this.setUsernameClient(usernameClient);
        this.upDateIn();
        this.upDateOut();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        int beds;
        do {
            System.out.println("CUANTAS CAMAS BUSCA?");
            System.out.println("1 - MATRIMONIAL");
            System.out.println("2 - DOBLE CAMA SIMPLE");
            System.out.println("3 - MATRIMONIAL CON DOS CAMAS SIMPLES");
            keyInput = scanner.nextLine();
            beds = Integer.parseInt(keyInput);
            if (beds > 3 || beds < 1) {
                flag = false;
                System.out.println("POR FAVOR, INGRESE UN NUMERO VALIDO");
            }else{
                flag = true;
            }
        }while(!flag);

        this.consultaHabitacion(beds, LocalDate.parse(this.getDateAdmission()), LocalDate.parse(this.getDateOut()), roomList, reservationList);
    }

    //metodo para ingreso de ingreso
    private void upDateIn() {
        Scanner scanner = new Scanner(System.in);
        String keyInputM, keyInputD, date;
        System.out.println("COLOQUE MES DE INGRESO");
        keyInputM = scanner.nextLine();
        System.out.println("COLOQUE DIA DE INGRESO");
        keyInputD = scanner.nextLine();
        date = "2021-" + keyInputM + "-" + keyInputD;
        this.setDateAdmission(date);
    }

    //metodo para ingresa fecha de egreso
    public void upDateOut() {
        Scanner scanner = new Scanner(System.in);
        String keyImputM, keyImputD, date;
        System.out.println("COLOQUE MES DE EGRESO");
        keyImputM = scanner.nextLine();
        System.out.println("COLOQUE DIA DE EGRESO");
        keyImputD = scanner.nextLine();
        date = "2021-" + keyImputM + "-" + keyImputD;
        this.setDateOut(date);
    }

    private int selectRoom(List<Room> listOfBeds, LocalDate dateIn, LocalDate dateOut, List<Reservation> reservationList) {
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

    private void resevar(int id, LocalDate in, LocalDate out, List<Reservation> reservationList) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        String pathReservation = "Reservas.json";
        System.out.println("SEGURO DE QUE QUERES RESERVAR?");
        System.out.println("1 - SI");
        System.out.println("0 - NO");
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
        return "RESERVA\n" +
                "DIA DE INGRESO : " + dateAdmission +
                "\nDIA DE EGRESO : " + dateOut +
                "\nNUMERO DE HABITACION : " + numRoom +
                "\nUSUARIO DEL CLIENTE : " + usernameClient +
                "\n\n";
    }


}
