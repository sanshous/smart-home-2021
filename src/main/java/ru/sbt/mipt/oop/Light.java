package ru.sbt.mipt.oop;

public class Light extends Thing{
    private boolean isOn;
    private final String id;

    Light( String id, boolean isOn) {
        super(isOn, id);
        this.id = id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
