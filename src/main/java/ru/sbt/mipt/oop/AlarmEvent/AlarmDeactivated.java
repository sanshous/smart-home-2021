package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmDeactivated implements AlarmState {
    private String activatingCode;

    private String deactivatingCode;

    public AlarmDeactivated(String activatingCode, String deactivatingCode) {
        this.activatingCode = activatingCode;
        this.deactivatingCode = deactivatingCode;
    }

    @Override
    public AlarmState activate(String code) {
        if(code.equals(activatingCode)) {
            return new AlarmActivated(activatingCode, deactivatingCode);
        }
        return new AlarmAlert(activatingCode, deactivatingCode);
    }

    @Override
    public AlarmState deactivate(String code) {
        return this;
    }

    @Override
    public AlarmState alert() {
        return this;
    }
}
