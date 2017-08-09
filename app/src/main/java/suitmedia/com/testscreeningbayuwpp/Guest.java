package suitmedia.com.testscreeningbayuwpp;

import java.util.List;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class Guest {

    private String name;
    private String birthdate;

    public Guest(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
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
    public class GuestList {
        private List<Guest> result;

        public List<Guest> getResult() {
            return result;
        }

        public void setResult(List<Guest> result) {
            this.result = result;
        }
    }
}
