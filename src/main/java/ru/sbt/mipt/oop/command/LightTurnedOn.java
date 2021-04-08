package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.EventProcessors.Action;
import ru.sbt.mipt.oop.EventProcessors.Actionable;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class LightTurnedOn extends Command{
    protected LightTurnedOn(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        Action action;
        action = (Actionable obj) -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.setOn(true);
            }
        };
        smartHome.execute(action);
    }
}
