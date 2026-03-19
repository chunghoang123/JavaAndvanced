package Bai3;

import java.util.Stack;

class RemoteControl {
    private Command[] slots;
    private Stack<Command> undoStack;

    public RemoteControl(int numberOfSlots) {
        slots = new Command[numberOfSlots];
        undoStack = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        if (slot >= 0 && slot < slots.length) {
            slots[slot] = command;
            System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + (slot + 1));
        }
    }

    public void pressButton(int slot) {
        if (slot >= 0 && slot < slots.length && slots[slot] != null) {
            slots[slot].execute();
            undoStack.push(slots[slot]); // Lưu vào lịch sử để undo
        } else {
            System.out.println("Nút này chưa được gán lệnh!");
        }
    }

    public void pressUndo() {
        if (!undoStack.isEmpty()) {
            Command lastCommand = undoStack.pop();
            lastCommand.undo();
        } else {
            System.out.println("Không còn lệnh nào để Undo.");
        }
    }
}
