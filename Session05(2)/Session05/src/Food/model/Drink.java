package Food.model;
public class Drink extends MenuItem {
    private Size size;

    public Drink(String id, String name, double basePrice, int stock, Size size) {
        super(id, name, basePrice, stock);
        this.size = size;
    }


    @Override
    public double calculatePrice() {
        switch (size) {
            case M:
                return getBasePrice() + 5000;
            case L:
                return getBasePrice() + 10000;
            default:
                return getBasePrice();
        }
    }

    @Override
    public String getType() {
        return "Drink-" + size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
