package rooms;

public class Room{
    private int numberBeds=0;
    private int id = 0;
    private RoomStatus roomStatus;
    public Room(){}

    public Room(int numberBeds, int id) {
        this.numberBeds = numberBeds;
        this.id=id;
        this.roomStatus=RoomStatus.DISPONIBLE;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }


    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberBeds=" + numberBeds +
                ", id=" + id +
                ", status=" + roomStatus +
                '}' + "\n" ;
    }
}
