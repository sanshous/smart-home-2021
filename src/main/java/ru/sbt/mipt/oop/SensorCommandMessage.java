package ru.sbt.mipt.oop;

public class SensorCommandMessage {
    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
