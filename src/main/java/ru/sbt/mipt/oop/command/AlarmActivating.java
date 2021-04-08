package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

public class AlarmActivating extends Command{
    protected AlarmActivating(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(smartHome.getAlarm().getActivatingCode());
    }
}
