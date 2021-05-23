package rooms;

public class Room {
    private int numberBeds=0;
    private boolean condition=false;
    private static Integer rooms=0;

    public Room(int numberBeds, boolean condition) {
        this.numberBeds = numberBeds;
        this.condition = condition;
        rooms++;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public static Integer getRooms() {
        return rooms;
    }

    public static void setRooms(Integer rooms) {
        Room.rooms = rooms;
    }
}
