package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

public class HallLightTurnedOn extends Command {
    protected HallLightTurnedOn(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        Action actionTurningOn;
        actionTurningOn = (Actionable obj) -> {
          if ( obj instanceof Light ) {
              Light light = (Light) obj;
              light.setOn(true);
          }
        };
        Action action;
        action = (Actionable obj) -> {
            if ( obj instanceof Room) {
                Room room = (Room) obj;
                if ( room.getName().equals("hall") ) {
                    room.execute(actionTurningOn);
                }
            }
        };
        smartHome.execute(action);
    }
}
