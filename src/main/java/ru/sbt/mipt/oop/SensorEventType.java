package ru.sbt.mipt.oop;

public enum SensorEventType {
    ALARM_ACTIVATE("ALARM_ACTIVATE"),
    ALARM_DEACTIVATE("ALARM_DEACTIVATE"),
    LIGHT_ON("LIGHT_ON"),
    LIGHT_OFF("LIGHT_OFF"),
    DOOR_OPEN("DOOR_OPEN"),
    DOOR_CLOSED("DOOR_CLOSED");

    private String value;

    SensorEventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
