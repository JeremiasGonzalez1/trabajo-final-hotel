package Empleados;
import java.util.List;
import java.util.Scanner;
import interfaces.Login;

public class Employee implements Login{
    private String username = "";
    private String password = "";
    private String turn = "";
    private Boolean isAdmin = false;
    private double salary = 0;


    public Employee(){
    }

    public Employee(String username, String password, String turn, double salary) {
        this.username = username;
        this.password = password;
        this.turn = turn;
        this.salary = salary;
        this.isAdmin = false;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getJob(){
        String n;
        if(isAdmin){
            n = "ADMINISTRADOR";
        }else
        {
            n = "RECEPCIONISTA";
        }

        return n;
    }

    @Override
    public <T> boolean login(List<T> genericList) {
        List <Employee> employeeList = (List <Employee>) genericList;
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
            if (!confirmUser(this.username, this.password, employeeList)) {
                flag = false;

                System.out.println("USUARIO / CONTRASEÑA INCORRECTOS\n");
                System.out.println("DESEA SALIR? \n" +
                        "1 - SI\n" +
                        "0 - NO");
//              se scanea exit, si es 1 se quiere ir, 0 si quiere reintentar.
                keyInput = scanner.nextLine();
                exit = Integer.parseInt(keyInput);
            }


        } while (!flag && exit == 0);

        return flag;

    }


    @Override
    public String toString() {
        return getJob() +
                "\nUSUARIO : " + username +
                "\nCONTRASEÑA : " + password +
                "\nTURNO : " + turn +
                "\nSALARIO : " + salary + "\n\n";
    }

    @Override
    public <T> boolean confirmUser(String Username, String Password, List<T> genericList) {
        boolean flag = false;

        List <Employee> auxList = (List<Employee>) genericList;

        for(Employee aux : auxList){
            if(Username.equals(aux.getUsername()) && Password.equals(aux.getPassword())){
                this.setAdmin(aux.isAdmin);
                this.setTurn(aux.turn);
                this.setSalary(aux.salary);
                flag = true;
            }
        }

        return flag;
    }

}
