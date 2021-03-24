package ru.sbt.mipt.oop;

public class Light{
    private boolean isOn;
    private final String id;

    Light( String id, boolean isOn) {
        this.isOn = isOn;
        this.id = id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getId() { return this.id;}
}
