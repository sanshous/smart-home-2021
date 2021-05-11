package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.*;

public class HallDoorEventProcessor implements EventProcessor {

    private boolean isValid(SensorEventType eventType) {
        return eventType.getValue().equals(SensorEventType.DOOR_CLOSED.getValue());
    }

    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {

        if(!isValid(sensorEvent.getType())) return;

        Action actionTurningOff;
        actionTurningOff = (Actionable obj) -> {
            if ( obj instanceof Light) {
                Light light = (Light) obj;
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandMessage.sendCommand(command);
            }
        };

        Action action;
        action = (Actionable obj) -> {
            if ( obj instanceof Room ) {
                Room room = (Room) obj;
                if ( room.getName().equals("hall") ) {
                    smartHome.execute(actionTurningOff);
                }
            }
        };
        smartHome.execute(action);
    }
}
