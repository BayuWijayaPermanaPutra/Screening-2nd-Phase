package suitmedia.com.testscreeningbayuwpp;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class Event {
    private int image;
    private String name;
    private String date;

    public Event(int image, String name, String date) {
        this.image = image;
        this.name = name;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
