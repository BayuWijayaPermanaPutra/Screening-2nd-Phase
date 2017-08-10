package suitmedia.com.testscreeningbayuwpp.Guest;

import java.util.List;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class Guest {
    private int id;
    private String name;
    private String birthdate;

    public Guest(int id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
