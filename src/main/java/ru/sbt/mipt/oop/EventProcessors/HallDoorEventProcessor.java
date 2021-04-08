package ru.sbt.mipt.oop.EventProcessors;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.*;

public class HallDoorEventProcessor extends ProcessSensorDecorator implements EventProcessor {

    public HallDoorEventProcessor(SensorDecorator wrap) {
        super(wrap);
    }

    public void alertAlarm(SmartHome smartHome) {
        wrap.alertAlarm(smartHome);
    }

    public void sendSMS() {
        wrap.sendSMS();
    }

    private boolean isValid(CCSensorEvent event) {
        return event.getEventType().equals(SensorEventType.DOOR_CLOSED.getValue());
    }

    public void processEvent(SmartHome smartHome, CCSensorEvent sensorEvent) {

        if(!isValid(sensorEvent)) return;

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
