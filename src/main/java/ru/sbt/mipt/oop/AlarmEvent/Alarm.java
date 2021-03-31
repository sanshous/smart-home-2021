package ru.sbt.mipt.oop.AlarmEvent;

public class Alarm {
    private AlarmState state;

    private final String activatingCode = "12345";

    private final String deactivatingCode = "54321";

    public String getActivatingCode() {
        return this.activatingCode;
    }

    public String getDeactivatingCode() {
        return this.deactivatingCode;
    }

    public void changeState(AlarmState state) {
        this.state = state;
    }

    public void activate(String code) {
        this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state.deactivate(code);
    }

    public void alert() {
        this.state.alert();
    }
}
