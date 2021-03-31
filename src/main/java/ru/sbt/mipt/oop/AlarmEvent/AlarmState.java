package ru.sbt.mipt.oop.AlarmEvent;

public abstract class AlarmState {
    protected Alarm alarm;

    public AlarmState (Alarm alarm) {
        this.alarm = alarm;
    }

    public abstract void activate(String code);

    public abstract void deactivate(String code);

    public abstract void alert();
}
