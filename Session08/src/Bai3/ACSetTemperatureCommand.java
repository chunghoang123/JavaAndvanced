package Bai3;

class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int prevTemperature;
    private int newTemperature;

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemperature = newTemp;
    }

    @Override
    public void execute() {
        prevTemperature = ac.getTemperature(); // Lưu lại trạng thái cũ trước khi thay đổi
        ac.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        ac.setTemperature(prevTemperature);
    }
}
