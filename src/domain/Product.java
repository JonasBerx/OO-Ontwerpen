package domain;

public class Product {
    private String title;
    private String type;
    private String id;

    public Product(String title, String type, String id) {
        setTitle(title);
        setType(type);
        setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
