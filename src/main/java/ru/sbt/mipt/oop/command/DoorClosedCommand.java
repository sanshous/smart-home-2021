package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;
import ru.sbt.mipt.oop.EventProcessors.SensorCommand;
import ru.sbt.mipt.oop.EventProcessors.SensorCommandMessage;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

public class DoorClosedCommand extends Command {
    protected DoorClosedCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
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
            if ( obj instanceof Room) {
                Room room = (Room) obj;
                if ( room.getName().equals("hall") ) {
                    smartHome.execute(actionTurningOff);
                }
            }
        };
        smartHome.execute(action);
    }
}
