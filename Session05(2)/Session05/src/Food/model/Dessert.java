package Food.model;

public class Dessert extends MenuItem {
    private boolean extraTopping;

    public Dessert(String id, String name, double basePrice, int stock, boolean extraTopping) {
        super(id, name, basePrice, stock);
        this.extraTopping = extraTopping;
    }

    @Override
    public double calculatePrice() {
        return extraTopping ? getBasePrice() + 7000 : getBasePrice();
    }

    @Override
    public String getType() {
        return extraTopping ? "Dessert-Topping" : "Dessert";
    }

    public boolean isExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(boolean extraTopping) {
        this.extraTopping = extraTopping;
    }
}