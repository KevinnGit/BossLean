package Implementation;

public class Accessories extends Product {

    private String type;
    private String color;
    private String length;


    public Accessories(String name, double price, int stockQuantity,String description, String type, String color, String length) {
        super(name, price, stockQuantity, description);
        this.type = type;
        this.color = color;
        this.length = length;
    }


    public String getType() {
        return type;
    }


    public String getColor() {
        return color;
    }


    public String getSize() {
        return length;
    }
}
