package Interaction;

import interfaces.RoomCheck;
import rooms.Room;

import java.util.Date;
import java.util.List;

public class Reservation implements RoomCheck {

    private Date dateAdmission = new Date();
    private Date dateOut = new Date();

    public Reservation(Date dateAdmission, Date dateOut) {
        this.dateAdmission = dateAdmission;
        this.dateOut = dateOut;
    }


    @Override
    public boolean consultaHabitacion(int numberBed, Date in, Date out) {
        ///bajar el archivo a una lista
        /*
         **/
        ///recorrer la lista y buscar los que tienen la misma cantidad de camas
        /*
        List <Room> listaPorCama = new ArrayList<>();
        for(Room room : listaDeHabitaciones)
        {
            ///bajo todas las habitaciones que tienen la misma cantidad de camas a un nuevo arreglo
            if(room.bed == NumberBed && room.condition == True)
            {
                listaPorCama.add(room);
            }
        }
        **/
        /*
        System.out.printl("Desea resevar?");
        ///scan
        if(True)///Si el scan es true
        {
        if(seleccionarHabitacion == 1){
        }
        }
        * */
        return false;
    }



    private int seleccionarHabitacion(List<Room> listOfBeds) {
        int flag = 0;
        /*
        int flag2 = 0;
        do{
        ///ingresar el id de la lista con un scan
        System.out.println("0-volver");
        flag2 = 0;
        for(Room room : listOfBeds)
        {
            if(room.id == id)
            {
                flag = 1;
            }
        }
        if(flag = 0){
        System.out.printl("No se encontro la habitacion desea\n Desea buscar otra habitacion?");
        ///scan flag2, si pone 1 es porque quiere volver a buscar, si pone 0 es porque no
        }else
        {
        reservar;
        }
        }while(flag2 = 1);
         */
        return flag;
    }

    private void resevar(int id, Date in, Date out) {
        ///obtener el id habitacion y agregar la reserva al archivo
        /*
        System.out.println("Seguro de que quiere reservar?");
        ///scan;
        if(flag == 1){
            ///cargar el archivo de reservas.
        }
         */

    }


}
