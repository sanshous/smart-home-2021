package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.AlarmEvent.Alarm;
import ru.sbt.mipt.oop.AlarmEvent.AlarmActivated;
import ru.sbt.mipt.oop.AlarmEvent.AlarmAlert;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmDecorator extends ProcessSensorDecorator{
    public AlarmDecorator(EventProcessor wrappee) {
        super(wrappee);
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) throws Exception {
        Alarm alarm = smartHome.getAlarm();
        if(alarm.getState() instanceof AlarmActivated) {
            alarm.alert();
            System.out.println("Sending sms");
        }
        else if(alarm.getState() instanceof AlarmAlert) {
            System.out.println("Sending sms");
        }
        else { super.processEvent(smartHome, sensorEvent); }
    }
}
