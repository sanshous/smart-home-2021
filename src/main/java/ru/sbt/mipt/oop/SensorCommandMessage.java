package ru.sbt.mipt.oop;

public class SensorCommandMessage implements Message{
    public void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
