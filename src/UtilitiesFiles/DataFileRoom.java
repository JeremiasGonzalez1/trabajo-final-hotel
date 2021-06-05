package UtilitiesFiles;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rooms.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileRoom {

    public DataFileRoom(){}

    public List<Room> saveOnFileRoom(String path,Room room, List<Room>roomList){
        try {
            File file = new File(path);
            ObjectMapper mapper=new ObjectMapper();
            if(file.exists()) {
                mapper.writeValue(file, room);
                roomList.add(room);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return roomList;
    }




}
