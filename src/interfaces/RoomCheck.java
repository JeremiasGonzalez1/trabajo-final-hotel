package interfaces;

import java.util.Date;

public interface RoomCheck {

    public boolean consultaHabitacion();

    boolean consultaHabitacion(int numberBed, Date in, Date out);
}
