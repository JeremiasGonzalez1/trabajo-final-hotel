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

    private String seeTypeRoom(){
        String type;
        if(this.getNumberBeds() == 1){
            type = "1 - MATRIMONIAL";
        }else if(this.getNumberBeds() == 2){
            type = "2 - DOBLE CAMA SIMPLE";
        }else
        {
            type = "3 - MATRIMONIAL CON DOS CAMAS SIMPLES";
        }

        return type;
    }

    @Override
    public String toString() {
        return "HABITACION NRO : " + id +
                "\nTIPO DE HABITACION : " + seeTypeRoom() +
                "\nESTADO : " + roomStatus +
                 "\n\n" ;
    }
}
