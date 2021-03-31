package ru.sbt.mipt.oop.AlarmEvent;

public class AlarmActivated extends AlarmState {
    public AlarmActivated(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate(String code) { }

    @Override
    public void deactivate(String code) {
        if(code.equals(alarm.getDeactivatingCode())) {
            alarm.changeState(new AlarmDeactivated(alarm));
        } else {
            alarm.changeState(new AlarmAlert(alarm));
        }
    }

    @Override
    public void alert() { }
}
