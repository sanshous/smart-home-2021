package ru.sbt.mipt.oop;

public class Thing {
    private final String id;
    private boolean isOn;

    public Thing(boolean isOn, String id) {
        this.isOn = isOn;
        this.id = id;
    }

    public String getId(){ return id; }

    public void setOn(boolean on){
        isOn = on;
    }
}
