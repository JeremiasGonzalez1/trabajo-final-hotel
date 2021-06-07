package interfaces;

import java.util.Date;
import java.util.List;

import Interaction.Reservation;
import rooms.Room;
public interface RoomCheck {

    public void consultaHabitacion(int numberBed, Date in, Date out, List<Room>roomList, List<Reservation>reservationList);
}
