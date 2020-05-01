public class Book {
    private String sku;
    private String title;
    private String author;
    private String description;
    private double price;

    public Book(){

    }
    public Book(String sku, String title, String author, String description, double price) {
        this.sku = sku;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return title;
    }
}
