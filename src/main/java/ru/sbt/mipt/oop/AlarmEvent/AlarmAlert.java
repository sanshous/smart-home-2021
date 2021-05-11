package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmAlert implements AlarmState {
    private String activatingCode;

    private String deactivatingCode;

    public AlarmAlert(String activatingCode, String deactivatingCode) {
        this.activatingCode = activatingCode;
        this.deactivatingCode = deactivatingCode;
    }

    @Override
    public AlarmState activate(String code) {
        return this;
    }

    @Override
    public AlarmState deactivate(String code) {
        return this;
    }

    @Override
    public AlarmState alert() {
        System.out.println("ALARM!");
        return this;
    }
}
