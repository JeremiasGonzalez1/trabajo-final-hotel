package Interaction;

import java.util.Scanner;

import Login.Login;

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

    public void menuClient(){

    }
}
