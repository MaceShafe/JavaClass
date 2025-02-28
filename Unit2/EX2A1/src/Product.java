public class Product {
//instance variables
    public String code = "unknown";
    private String description;
    private double price;

    //constructors


    public Product() {
        this.code = "unknown";
        this.description = "unknown";
        this.price = 0.0;
    }

    public Product(String code) {
        this.code = code;
        this.description = "unknown";
        this.price = 0.0;
    }

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    //getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
