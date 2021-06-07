package rooms;

public class Room{
    private int numberBeds=0;
    private int id = 0;
    private boolean status=true;

    public Room(){}

    public Room(int numberBeds, int id, boolean status) {
        this.numberBeds = numberBeds;
        this.status = status;
        this.id=id;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isCondition() {
        return status;
    }

    public void setCondition(boolean condition) {
        this.status = condition;
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
                ", status=" + status +
                '}';
    }
}
