package interfaces;

import java.util.List;

public interface Login {
    public <T> boolean login (List <T> genericList);

    public <T> boolean confirmUser(String Username, String Password, List<T> genericList);

}
