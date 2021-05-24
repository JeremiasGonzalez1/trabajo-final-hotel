package Empleados;

public class Employee {
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
}
