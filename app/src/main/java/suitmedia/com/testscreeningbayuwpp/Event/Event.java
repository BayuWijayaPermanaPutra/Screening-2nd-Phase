package suitmedia.com.testscreeningbayuwpp.Event;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class Event {
    private int image;
    private String name;
    private String date;
    private String tags;
    private String description;
    private Double latitude;
    private Double longitude;

    public Event(int image, String name, String date, String tags, String description, Double latitude, Double longitude) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.tags = tags;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
