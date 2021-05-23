package Empleados;

public class Employee {
    private  username="";
    private String password="";
    private String turn="";
    private string carlos="";

    public Employee(){
    }

    public Employee(String username, String password, String turn) {
        this.username = username;
        this.password = password;
        this.turn = turn;
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
