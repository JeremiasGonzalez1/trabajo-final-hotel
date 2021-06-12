package Interaction;
import java.util.List;
import java.util.Scanner;
import UtilitiesFiles.DataFile;
import interfaces.Login;

public class Client implements Login {
    private String name = "";
    private String phone = "";
    private String adress = "";
    private String username = "";
    private String password = "";
    private String id = ""; //documento
    private boolean active = false;

    public Client() {
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
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


    @Override
    public String toString() {
        return
                "\nClIENTE \n" +
                "\nNOMBRE : " + name +
                "\nTELEFONO : " + phone +
                "\nDIRECCION : " + adress +
                "\nUSUARIO : " + username +
                "\nCONTRASEÑA : " + password +
                "\nDNI : " + id + "\n\n";
    }

    public void seeReservations(List<Reservation> reservationList) {
        for (Reservation reservation : reservationList) {
            if (reservation.getUsernameClient().equals(this.username)) {
                System.out.println(reservation.toString());
            }
        }
    }

    public void seeProfile() {
        System.out.println(this.toString());
    }

    public void changeProfile(List<Client> clientList) {
        int data = 0;
        do {
            data = menuChangeProfile();
            Scanner scanner = new Scanner(System.in);
            String keyInput;
            System.out.println("INGRESE EL NUEVO VALOR");
            switch (data) {
                case 1:

                    keyInput = scanner.nextLine();
                    this.setName(keyInput);
                    System.out.println("EL NOMBRE SE CAMBIO A " + this.getName());
                    break;
                case 2:

                    keyInput = scanner.nextLine();
                    this.setPhone(keyInput);
                    System.out.println("EL TELEFONO SE CAMBIO A ");
                    break;
                case 3:

                    keyInput = scanner.nextLine();
                    this.setAdress(keyInput);
                    System.out.println("LA DIRECCION SE CAMBIO A " + this.getAdress());
                    break;
                case 4:
                    keyInput = scanner.nextLine();
                    this.setUsername(keyInput);
                    System.out.println("EL USERNAME SE CAMBIO A " + this.getUsername());
                    break;
                case 5:

                    keyInput = scanner.nextLine();
                    this.setPassword(keyInput);
                    System.out.println("LA CONTRASEÑA SE CAMBIO A " + this.getPassword());
                    break;
                case 6:
                    keyInput = scanner.nextLine();
                    this.setId(keyInput);
                    System.out.println("EL DNI SE CAMBIO A " + this.getId());
                    break;
                case 7:
                    System.out.println(this.isActive());
                    System.out.println("SEGURO QUE QUIERE DAR DE BAJA SU CUENTA?");
                    keyInput=scanner.nextLine();
                    System.out.println("1 - SI");
                    System.out.println("0 - NO");
                    keyInput = scanner.nextLine();
                    if (keyInput.equals("1")) {
                        this.setActive(false);
                    }
            }
        } while (data != 0);
    }

    private int menuChangeProfile() {
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        System.out.println("que campo desea modificar?");
        System.out.println("1 - NOMBRE \n" +
                "2 - TELEFONO\n" +
                "3 - DIRECCION\n" +
                "4 - USUARIO \n" +
                "5 - CONTRASEÑA \n" +
                "6 - DNI \n" +
                "7 - DARSE DE BAJA"+

                "0-SALIR");
        keyInput = scanner.nextLine();
        int aux = Integer.parseInt(keyInput);
        return aux;
    }


    @Override
    public <T> boolean login(List<T> genericList) {
        String username;
        String password;
        List<Client> clientList = (List<Client>) genericList;
        boolean flag = true;
        int exit = 0;
        int flagAux = 0;
        Scanner scanner = new Scanner(System.in);
        String keyInput;
        do {
            flag = true;
            exit = 0;
            System.out.println("INGRESE USERNAME");
            keyInput = scanner.nextLine();
            this.username = keyInput;
            System.out.println("INGRESE CONTRASEÑA");
            keyInput = scanner.nextLine();
            this.password = keyInput;
            System.out.println("");
            boolean aux = confirmUser(this.username, this.password, clientList);
            if (!aux) {
                flag = false;

                System.out.println("EL USUARIO / CONTRASEÑA SON INCORRECTOS\n");
                System.out.println("DESEA SALIR?? \n" +
                        "1 - SI\n" +
                        "0 - NO");
//              se scanea exit, si es 1 se quiere ir, 0 si quiere reintentar.
                keyInput = scanner.nextLine();
                exit = Integer.parseInt(keyInput);
            }
            if (aux) {
                if (!this.isActive()) {
                    System.out.println("SU USUARIO NO ESTÁ ACTIVO, ESPERE A UN ADMINISTRADOR PARA DAR DE ALTA");
                    flagAux = 1;
                }
            }

        } while (!flag && exit == 0 && !this.isActive());

        if (flagAux == 1) {
            flag = false;
        }
        return flag;

    }

    @Override
    public <T> boolean confirmUser(String Username, String Password, List<T> genericList) {
        boolean flag = false;

        List<Client> auxList = (List<Client>) genericList;

        for (Client aux : auxList) {
            if (Username.equals(aux.getUsername()) && Password.equals(aux.getPassword())) {
                this.setAdress(aux.getAdress());
                this.setId(aux.getId());
                this.setName(aux.getName());
                this.setPhone(aux.getPhone());
                this.setActive(aux.isActive());
                flag = true;
            }
        }
        return flag;
    }

    public void createNewClient(List<Client> clientList, String path) {
        Scanner scanner = new Scanner(System.in);
        String keyInput;

        System.out.println("INGRESE NOMBRE");
        this.setName(scanner.nextLine());
        System.out.println("INGRESE TELEFONO");
        this.setPhone(scanner.nextLine());
        System.out.println("INGRESE DIRECCION");
        this.setAdress(scanner.nextLine());
        System.out.println("INGRESE USUARIO");
        this.setUsername(scanner.nextLine());
        System.out.println("INGRESE CONTRASEÑA");
        this.setPassword(scanner.nextLine());
        System.out.println("INGRESE DNI");
        this.setId(scanner.nextLine());
        this.setActive(true);
        DataFile dataFile = new DataFile();
        clientList.add(this);
        dataFile.saveOnFile(clientList, path);

    }

}
