package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmAlert extends AlarmState {
    public AlarmAlert(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate(String code) {
        return;
    }

    @Override
    public void deactivate(String code) {
        return;
    }

    @Override
    public void alert() {
        System.out.println("ALARM!");
    }
}
