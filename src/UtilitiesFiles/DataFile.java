package UtilitiesFiles;

import Interaction.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public DataFile() {
    }


    public void saveOnFile(Reservation reservation, String path) {
        List<Reservation> reservationList = new ArrayList<>();

        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();

            if (file.exists()) {
                reservationList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Reservation.class));
            }
            reservationList.add(reservation);
            mapper.writeValue(file, reservationList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Reservation> readOnFile(String path){
        List<Reservation>reservationList=new ArrayList<>();
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file =new File(path);
            if(file.exists()){
                reservationList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Reservation.class));
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return reservationList;
    }
}
