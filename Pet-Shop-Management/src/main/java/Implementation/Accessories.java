package Implementation;

public class Accessories extends Product {

    private String type;
    private String color;
    private String size;


    public Accessories(String name, double price, int stockQuantity, String description, String type, String color, String size) {
        super(name, price, stockQuantity, description);
        this.type = type;
        this.color = color;
        this.size = size;
    }


    public String getType() {
        return type;
    }


    public String getColor() {
        return color;
    }


    public String getSize() {
        return size;
    }
}
