package Empleados;

import java.util.Date;

public class Employee {
<<<<<<< HEAD
    private  String username="";
    private String password="";
    private String turn="";


=======
    private String username= "";
    private String password="";
    private String turn="";
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double salary;
>>>>>>> origin/master
    public Employee(){
    }

    public Employee(String username, String password, String turn, double salary) {
        this.username = username;
        this.password = password;
        this.turn = turn;
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

    public void singing(String username){
        Date dateIn=new Date();
        /*funcion para el guardado de fichaje en el archivo*/
    }

    public void seeSignings(String username){
        //funcion para la apertura de archivo y lectura del mismo
    }



}
