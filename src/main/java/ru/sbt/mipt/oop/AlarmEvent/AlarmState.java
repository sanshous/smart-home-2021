package ru.sbt.mipt.oop.AlarmEvent;

public interface AlarmState {
    AlarmState activate(String code);

    AlarmState deactivate(String code);

    AlarmState alert();
}
