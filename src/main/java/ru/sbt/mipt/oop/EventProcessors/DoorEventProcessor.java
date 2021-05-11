package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.*;

public class DoorEventProcessor implements EventProcessor {

    private boolean isValid(SensorEventType eventType) {
        return eventType.getValue().equals(SensorEventType.DOOR_OPEN.getValue()) ||
                eventType.getValue().equals(SensorEventType.DOOR_CLOSED.getValue());
    }

    public void  processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isValid(event.getType())) return;
        boolean isOpen = event.getType() == SensorEventType.DOOR_OPEN;

        Action action;
        action = (Actionable obj) -> {
            if (obj instanceof Door) {
                Door door = (Door) obj;
                door.setOpen(isOpen);
            }
        };
        smartHome.execute(action);
    }
}
