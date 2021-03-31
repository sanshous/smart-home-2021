package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SmartHome;

public interface SensorDecorator {
    void sendSMS();
    void alertAlarm(SmartHome smartHome);
}
