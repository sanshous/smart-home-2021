package ru.sbt.mipt.oop.EventProcessors;

import com.coolcompany.smarthome.events.CCSensorEvent;
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

    private boolean isValid(CCSensorEvent eventType) {
        return eventType.getEventType().equals(SensorEventType.LIGHT_ON.getValue()) ||
                eventType.getEventType().equals(SensorEventType.LIGHT_OFF.getValue());
    }

    @Override
    public void processEvent(SmartHome smartHome, CCSensorEvent sensorEvent) throws Exception {
        if(!isValid(sensorEvent)) return;
        boolean isOn = (sensorEvent.getEventType() == SensorEventType.LIGHT_ON.getValue());
        Action action;
        action = (Actionable obj) -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                if (light.getId().equals(sensorEvent.getObjectId())) {
                    light.setOn(isOn);
                }
            }
        };
        smartHome.execute(action);
    }
}
