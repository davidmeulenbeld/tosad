package domain;

/**
 * object for sending columns
 */
public class column {
    String name;
    String type;
//getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "column{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public column(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
