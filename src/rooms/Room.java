package rooms;

public class Room {
    private int numberBeds=0;
    private int id = 0;
    private RoomStatus status;
    private static Integer rooms=0;

    public enum RoomStatus {
        DISPONIBLE,
        OCUPADA,
        RAPRANDOSE,
        LIMPIANDOSE;
    }

    public Room(int numberBeds, RoomStatus status) {
        this.numberBeds = numberBeds;
        this.status = status;

        rooms++;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }

    public RoomStatus isCondition() {
        return status;
    }

    public void setCondition(RoomStatus condition) {
        this.status = condition;
    }

    public static Integer getRooms() {
        return rooms;
    }

    public static void setRooms(Integer rooms) {
        Room.rooms = rooms;
    }

}
