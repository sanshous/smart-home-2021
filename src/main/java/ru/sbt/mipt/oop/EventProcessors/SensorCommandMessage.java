package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.SensorCommand;

public class SensorCommandMessage {
    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
