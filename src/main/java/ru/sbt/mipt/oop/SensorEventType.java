package ru.sbt.mipt.oop;

public enum SensorEventType {
    LIGHT_ON("LIGHT_ON"),
    LIGHT_OFF("LIGHT_OFF"),
    DOOR_OPEN("DOOR_OPEN"),
    DOOR_CLOSED("DOOR_CLOSED");

    private String value;

    private SensorEventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
