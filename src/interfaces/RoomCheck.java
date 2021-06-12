package interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import Interaction.Reservation;
import rooms.Room;
public interface RoomCheck {

    public void consultaHabitacion(int numberBed, LocalDate in, LocalDate out, List<Room>roomList, List<Reservation>reservationList);
}
