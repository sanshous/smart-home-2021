package ru.sbt.mipt.oop.AlarmEvent;

import ru.sbt.mipt.oop.SensorEventType;

public class AlarmEvent {
    private final SensorEventType type;
    private final String code;

    public AlarmEvent(SensorEventType type, String code) {
        this.type = type;
        this.code = code;
    }

    public SensorEventType getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }
}
