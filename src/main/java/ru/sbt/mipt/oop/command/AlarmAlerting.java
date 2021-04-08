package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

public class AlarmAlerting extends Command{
    protected AlarmAlerting(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void execute() {
        smartHome.getAlarm().alert();
    }
}
