package Interaction;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;

import Interaction.Reservation;
import interfaces.Login;
import rooms.Room;

public class Client implements Login {
    private String name = "";
    private String phone = "";
    private String adress = "";
    private String username = "";
    private String password = "";
    private String id = "";
    private boolean reservation = false;
    private boolean active = false;

    public Client() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Client(String name, String phone, String adress, String username, String password, String id) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.username = username;
        this.password = password;
        this.id = id;
        this.reservation = false;
        this.active = false;
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

    public void createReservation(List<Reservation> reservationList, List<Room> roomList, String usernameClient) {
        Reservation reservation = new Reservation();
        reservation.dataReservation(roomList, reservationList, this.getUsername());
    }

    private void seeReservations(List<Reservation> reservationList) {

        for (Reservation reservation : reservationList) {
            if (reservation.getUsernameClient() == this.username) {
                System.out.println(reservation.toString());
            }
        }
    }

    private void seeProfile() {
        System.out.println(this.toString());
    }

    private void changeProfile(List<Client> clientList) {
        int data;
        do {
            data = menuChangeProfile();
            Scanner scanner = new Scanner(System.in);
            String keyInput;
            switch (data) {
                case 1:
                    System.out.println(this.getName());
                    keyInput = scanner.nextLine();
                    this.setName(keyInput);
                    System.out.println("EL NOMBRE SE CAMBIO A " + this.getName());
                case 2:
                    System.out.println(this.getPhone());
                    keyInput = scanner.nextLine();
                    this.setPhone(keyInput);
                    System.out.println("EL TELEFONO SE CAMBIO A ");
                case 3:
                    System.out.println(this.getAdress());
                    keyInput = scanner.nextLine();
                    this.setAdress(keyInput);
                    System.out.println("LA DIRECCION SE CAMBIO A " + this.getAdress());
                case 4:
                    System.out.println(this.getUsername());
                    keyInput = scanner.nextLine();
                    this.setUsername(keyInput);
                    System.out.println("EL USERNAME SE CAMBIO A " + this.getUsername());
                case 5:
                    System.out.println(this.getPassword());
                    keyInput = scanner.nextLine();
                    this.setPassword(keyInput);
                    System.out.println("LA CONTRASEÑA SE CAMBIO A " + this.getPassword());
                case 6:
                    System.out.println(this.getId());
                    keyInput = scanner.nextLine();
                    this.setId(keyInput);
                    System.out.println("EL DNI SE CAMBIO A " + this.getId());
                    break;
            }
        } while (data != 0);
    }

    private int menuChangeProfile() {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("que campo desea modificar?");
        System.out.println("1-NOMBRE \n" +
                "2-TELEFONO\n" +
                "3-DIRECCION\n" +
                "4-USUARIO \n" +
                "5-CONTRASEÑA \n" +
                "6-DNI \n" +
                "0-SALIR");
        keyInput = scanner.nextLine();
        int aux = Integer.parseInt(keyInput);
        return aux;
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

    @Override
    public <T> boolean login(List<T> genericList) {
        String username;
        String password;
        List<Client> clientList = (List<Client>) genericList;
        boolean flag = true;
        int exit = 0;
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        do {
            flag = true;
            exit = 0;
            System.out.println("Ingrese username");
            keyInput = scanner.nextLine();
            this.username = keyInput;
            System.out.println("Ingrese password");
            keyInput = scanner.nextLine();
            this.password = keyInput;
            System.out.println("");
            if(!this.isActive()) {
                if (!confirmUser(this.username, this.password, clientList)) {
                    flag = false;

                    System.out.println("El usuario o la contraseña son incorrectos\n");
                    System.out.println("Desea salir?");
//              se scanea exit, si es 1 se quiere ir, 0 si quiere reintentar.
                    keyInput = scanner.nextLine();
                    exit = Integer.parseInt(keyInput);
                }
            }else
            {
                System.out.println("SU USUARIO NO ESTÁ ACTIVO, ESPERE A UN ADMINISTRADOR PARA DAR DE ALTA");
            }
        } while (!flag && exit == 0 && this.isActive());

        return flag;

    }

    @Override
    public <T> boolean confirmUser(String Username, String Password, List<T> genericList) {
        boolean flag = false;

        List<Client> auxList = (List<Client>) genericList;

        for (Client aux : auxList) {
            if (Username.equals(aux.getUsername()) && Password.equals(aux.getUsername())) {
                this.setAdress(aux.getAdress());
                this.setId(aux.getId());
                this.setName(aux.getName());
                this.setPhone(aux.getPhone());
                this.setReservation(aux.reservation);
                flag = true;
            }
        }

        return flag;
    }
}
