package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class LightEventProcessor extends ProcessSensorDecorator implements EventProcessor {


    public LightEventProcessor(SensorDecorator wrap) {
        super(wrap);
    }

    public void alertAlarm(SmartHome smartHome) {
        wrap.alertAlarm(smartHome);
    }

    public void sendSMS() {
        wrap.sendSMS();
    }

    private boolean isValid(SensorEventType eventType) {
        return eventType.getValue().equals(SensorEventType.LIGHT_ON.getValue()) ||
                eventType.getValue().equals(SensorEventType.LIGHT_OFF.getValue());
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!isValid(event.getType())) return;
        boolean isOn = (event.getType() == SensorEventType.LIGHT_ON);
        Action action;
        action = (Actionable obj) -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                if (light.getId().equals(event.getObjectId())) {
                    light.setOn(isOn);
                }
            }
        };
        smartHome.execute(action);
    }
}
