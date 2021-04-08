package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

abstract public class Command {
    protected SmartHome smartHome;

    protected Command(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public abstract void execute();
}
