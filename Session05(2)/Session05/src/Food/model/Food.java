package Food.model;
public class Food extends MenuItem {
    public Food(String id, String name, double basePrice, int stock) {
        super(id, name, basePrice, stock);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }

    @Override
    public String getType() {
        return "Food";
    }
}
