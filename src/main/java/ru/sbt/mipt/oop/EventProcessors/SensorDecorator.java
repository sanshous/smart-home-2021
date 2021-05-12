package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SmartHome;

public interface SensorDecorator {
    void processEvent(SmartHome smartHome, SensorEvent sensorEvent) throws Exception;
}
