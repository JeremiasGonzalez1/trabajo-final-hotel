package Interaction;

public class Client extends Hotel{
    private String username="";
    private String password="";
    private int id=0;
    private boolean reservation=false;

    public Client(String name, String adress, String phone, String email, String username, String password, int id, boolean reservation) {
        super(name, adress, phone, email);
        this.username = username;
        this.password = password;
        this.id = id;
        this.reservation = reservation;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }
}
