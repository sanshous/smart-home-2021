package ru.sbt.mipt.oop;

public class LightEventProcessor implements EventProcessor {

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
                    //System.out.println(light.getId());
                }
            }
        };
        smartHome.execute(action);
    }
}
