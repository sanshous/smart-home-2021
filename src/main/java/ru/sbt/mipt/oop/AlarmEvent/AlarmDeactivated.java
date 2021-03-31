package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmDeactivated extends AlarmState {

    public AlarmDeactivated(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate(String code) {
        if(code.equals(alarm.getActivatingCode())) {
            alarm.changeState(new AlarmActivated(alarm));
        }
    }

    @Override
    public void deactivate(String code) {
        return;
    }

    @Override
    public void alert() {
        return;
    }
}
