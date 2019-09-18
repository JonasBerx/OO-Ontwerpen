package domain;

public abstract class Product {
    private String title;
    private String id;

    public Product(String title, String id) {
        setTitle(title);
        setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
