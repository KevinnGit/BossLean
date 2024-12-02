package Implementation;

public class Animals extends Product{

    private int age;
    private String breed;



    public Animals(String breed, double price, int stockQuantity, String description, int age, String name) {
        super(breed, price, stockQuantity, description);
        this.age = age;
        this.breed = breed;

    }


    public int getAge() {
        return age;
    }


    public String getBreed() {
        return breed;
    }



}
