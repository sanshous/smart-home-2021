package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.command.Command;

public class TurnOffLightCommand extends Command {

    protected TurnOffLightCommand(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        Action action;
        action = (Actionable obj) -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.setOn(false);
            }
        };
        smartHome.execute(action);
    }
}
