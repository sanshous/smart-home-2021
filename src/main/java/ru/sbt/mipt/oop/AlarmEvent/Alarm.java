package ru.sbt.mipt.oop.AlarmEvent;

public class Alarm {
    private AlarmState state;

    private final String activatingCode = "12345";

    private final String deactivatingCode = "54321";

    public void activate(String code) {
        this.state = this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state = this.state.deactivate(code);
    }

    public AlarmState getState(){ return this.state; }

    public void alert() {
        this.state = this.state.alert();
    }
}
