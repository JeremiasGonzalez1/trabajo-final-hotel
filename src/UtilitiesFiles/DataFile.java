package UtilitiesFiles;

import Interaction.Reservation;
import Sign.Sign;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public DataFile() {
    }

    public <T> List<T> readLists(String url, Class<T> genericOb) {
        List<T> data = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(url);
            if (file.exists()) {
                data = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, genericOb));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    public <T> void saveOnFile(List<T> list, String path){
        ObjectMapper mapper = new ObjectMapper();

        try{
            File file = new File(path);
            mapper.writeValue(file, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

