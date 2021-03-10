package ru.sbt.mipt.oop;

public class Door extends Thing{
    private final String id;
    private boolean isOn;

    public Door(boolean isOpen, String id) {
        super(isOpen, id);
        this.id = id;
    }

    public void setOpen(boolean open) {
        isOn = open;
    }
}
