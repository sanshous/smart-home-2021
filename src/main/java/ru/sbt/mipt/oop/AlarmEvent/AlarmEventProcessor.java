package ru.sbt.mipt.oop.AlarmEvent;

import ru.sbt.mipt.oop.EventProcessors.EventProcessor;
import ru.sbt.mipt.oop.EventProcessors.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmEventProcessor {
    public void processEvent(SmartHome smartHome, AlarmEvent event) {
        if(event.getType().getValue().equals(SensorEventType.ALARM_ACTIVATE.getValue())) {
            smartHome.getAlarm().activate(event.getCode());
        }
        else if(event.getType().getValue().equals(SensorEventType.ALARM_DEACTIVATE.getValue())) {
            smartHome.getAlarm().deactivate(event.getCode());
        }
    }

}
