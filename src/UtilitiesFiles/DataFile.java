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


    public List<Login> loginsList(String path){

        File file = new File(path);

        List <Login> logins = new ArrayList<>();

        try{
            ObjectMapper mapper = new ObjectMapper();

            if(file.exists()){
                logins = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Login.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logins;
    }

    public List<Sign> employeeSignsList(){
        String path = "sign.json";//Direccion del archivo
        File file = new File(path);
        List <Sign> signs = new ArrayList();
        try {
            ObjectMapper mapper = new ObjectMapper();

            if(file.exists()){
                signs = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Sign.class));
            }

        }catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }

        return signs;
    }

    public void employeeSingOut(Sign sign){
        String path = "sign.json";
        File file = new File(path);
        List <Sign> signs = new ArrayList<>();

        try{
            ObjectMapper mapper = new ObjectMapper();

            signs = employeeSignsList();

            mapper.writeValue(file, signs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

