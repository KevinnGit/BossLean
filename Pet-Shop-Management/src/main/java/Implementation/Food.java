package Implementation;

public class Food extends Product{

    private String TypeOfFood;

    public Food (String name, double price, int stockQuantity, String description, String TypeOfFood) {
        super(name, price, stockQuantity, description);
        this.TypeOfFood = TypeOfFood;
    }

    public String getTypeOfFood() {
        return TypeOfFood;
    }
}
