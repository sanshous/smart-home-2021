package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmActivated implements AlarmState {
    private String activatingCode;

    private String deactivatingCode;

    public AlarmActivated(String activatingCode, String deactivatingCode) {
        this.activatingCode = activatingCode;
        this.deactivatingCode = deactivatingCode;
    }

    public AlarmState activate(String code) {
        return this;
    }

    public AlarmState deactivate(String code) {
        if (code.equals(deactivatingCode)) {
            return new AlarmDeactivated(activatingCode, deactivatingCode);
        }
        return new AlarmAlert(activatingCode, deactivatingCode);
    }

    public AlarmState alert() {
        return new AlarmAlert(activatingCode, deactivatingCode);
    }
}
