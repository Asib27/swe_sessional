package offline1_1.cooler;

public class Cooler {
    int price;
    String description;
    String name;

    protected Cooler(String name, int price, String description){
        this.price = price;
        this.description = description;
    }


    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
