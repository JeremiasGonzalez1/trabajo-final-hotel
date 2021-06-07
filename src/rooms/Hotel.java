package rooms;

 public class Hotel {
    private final String name="El comandante fort";
    private final String adress="San martin 1111";
    private final String phone="2235112671";
    private final String email="yomanejounrollsroyce@gmail.com";
    protected static int rooms=0;


    public Hotel(){
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public static int getRooms() {
        return rooms;
    }

    public static void setRooms(int rooms) {
        Hotel.rooms = rooms;
    }
}
