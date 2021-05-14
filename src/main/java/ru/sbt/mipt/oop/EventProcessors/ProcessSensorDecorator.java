package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.SensorDecorator;
import ru.sbt.mipt.oop.SmartHome;

public class ProcessSensorDecorator implements SensorDecorator {
    protected SensorDecorator wrap;

    public ProcessSensorDecorator(SensorDecorator wrap) {
        this.wrap = wrap;
    }

    public void sendSMS() {
        wrap.sendSMS();
    }

    public void alertAlarm(SmartHome smartHome) {
        wrap.alertAlarm(smartHome);
    }
}
