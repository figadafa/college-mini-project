package Praktikum.Users;
import java.time.LocalDateTime;
public class Item {
    private String name;
    private String description;
    private LocalDateTime date;
    private String location;

    public Item(String name, String description, LocalDateTime date, String location) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
