package Interaction;

import java.util.Date;
import java.util.Scanner;

import Login.Login;
import Interaction.Reservation;

public class Client {
    private String name = "";
    private String phone = "";
    private String adress = "";
    private String username = "";
    private String password = "";
    private String id = "";
    private boolean reservation = false;

    public Client() {
    }

    public Client(String name, String phone, String adress, String username, String password, String id, boolean reservation) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.username = username;
        this.password = password;
        this.id = id;
        this.reservation = reservation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public void registration() {

        String keyboardInput = "";
        System.out.println("ingrese su nombre: ");
        Scanner scanner = new Scanner(System.in);
        keyboardInput = scanner.nextLine();
        this.name = keyboardInput;

        System.out.println("ingrese su telefono: ");
        keyboardInput = scanner.nextLine();
        this.phone = keyboardInput;

        System.out.println("ingrese su direccion: ");
        keyboardInput = scanner.nextLine();
        this.adress = keyboardInput;

        System.out.println("ingrese usuario: ");
        keyboardInput = scanner.nextLine();
        this.username = keyboardInput;

        System.out.println("ingrese su contraseña: ");
        keyboardInput = scanner.nextLine();
        this.password = keyboardInput;

        System.out.println("ingrese su DNI: ");
        keyboardInput = scanner.nextLine();
        this.id = keyboardInput;

        this.reservation = false;

        //*falta llamado a la funcion para almacenar en el archivo*
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", reservation=" + reservation +
                '}';
    }

    public void loginAccount() {
        Login login = new Login(this.getUsername(), this.getPassword());
        boolean x;
        do {
            x = login.confirmUser();
            if (!x) {
                System.out.println("usuario / contraseña incorrecto");
            }
        } while (x != true);
    }

    public void menuClient() {
        int option = 0;
        do {
            option = optionsMenu();
            switch (option) {
                case 1:

            }
        } while (option != 0);
    }

    //**FUNCION IMPORTANTE NO DEJAR DE VER**///

    public void createReservation() {

        Reservation reservation = new Reservation();
        reservation = upDateIn(reservation);
        reservation=upDateOut(reservation);
        System.out.println(reservation.toString());

        //Falta parte de codigo que hay que realizar para ver que habitaciones estan disponibles para rentar.
        //no olvidarse
    }

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

    private int optionsMenu() {
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
}
