package Empleados;
import UtilitiesFiles.DataFile;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Login.Login;
import Sign.Sign;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee implements Serializable{
    private String username = "";
    private String password = "";
    private String turn = "";
    private double salary = 0;
    private Sign sign;
    private static final long serialVersionUID = 0;

    public Employee() {
    }

    public Employee(String username, String password, String turn, double salary) {
        this.username = username;
        this.password = password;
        this.turn = turn;
        this.salary = salary;
        this.sign = new Sign();
    }

    private Sign getSign() {
        return sign;
    }

    private void setSign(Sign sign) {
        this.sign = sign;
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

    public void signIn(){
        Date date = new Date();
        this.sign.setDateIn(date);
        this.sign.setDateOut(null);
        this.sign.setUsername(this.username);
    }

    public void signOut(List<Sign> signList) {
        Date date = new Date();
        DataFile data = new DataFile();

        this.sign.setDateOut(date);

        signList = data.readLists("sign.json", Sign.class);

        signList.add(this.sign);

        data.saveOnFile(signList, "sign.json");

        this.sign = null;

    }

    public boolean loginEmpoyee() {
        String username;
        String password;
        boolean flag = true;
        int exit = 0;

        do {
            flag = true;
            exit = 0;
            System.out.println("Ingrese username");
            System.out.println("Ingrese password");
            System.out.println("");
            /*scanear nuevos username y password)*/

            Login login = new Login(this.username, this.password);


            if (!login.confirmUser(login, "employeeLogin.json")) {
                flag = false;

                System.out.println("El usuario o la contraseña son incorrectos\n");
                System.out.println("Desea salir?");
//              se scanea exit, si es 1 se quiere ir, 0 si quiere reintentar.
            }


        }while(!flag && exit == 0);

        return flag;

    }
}
