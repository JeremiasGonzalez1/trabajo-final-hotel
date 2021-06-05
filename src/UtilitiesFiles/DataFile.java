package UtilitiesFiles;

import Interaction.Reservation;
import Login.Login;
import Sign.Sign;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public DataFile() {
    }


    public void saveOnFileReservation(Reservation reservation, String path) {
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

    public <T> List<T> readLists(String url, Class<T> genericOb) {
        List<T> data = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(url);
            if (file.exists()) {
                data = mapper.readValue(file,
                        mapper.getTypeFactory().constructCollectionType(List.class, genericOb));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }




    public void employeeSingOut(Sign sign, List<Sign> signList) {
        String path = "sign.json";
        File file = new File(path);
        List<Sign> signs = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();

            signList.add(sign);

            mapper.writeValue(file, signs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

