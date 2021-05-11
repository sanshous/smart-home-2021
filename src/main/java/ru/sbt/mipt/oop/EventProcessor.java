package ru.sbt.mipt.oop;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent sensorEvent) throws Exception;
}
