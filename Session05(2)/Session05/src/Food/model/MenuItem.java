package Food.model;
public abstract class MenuItem {
    private String id;
    private String name;
    private double basePrice;
    private int stock;

    public MenuItem(String id, String name, double basePrice, int stock) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.stock = stock;
    }

    public abstract double calculatePrice();

    public abstract String getType();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + getType() + '\'' +
                ", price=" + calculatePrice() +
                ", stock=" + stock +
                '}';
    }
}