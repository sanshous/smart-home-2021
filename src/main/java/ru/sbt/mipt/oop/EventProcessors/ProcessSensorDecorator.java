package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.EventProcessors.SensorDecorator;
import ru.sbt.mipt.oop.SmartHome;

public class ProcessSensorDecorator implements SensorDecorator {
    private EventProcessor wrap;

    public ProcessSensorDecorator(EventProcessor wrap) {
        this.wrap = wrap;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) {
            wrap.processEvent(smartHome, sensorEvent);
    }
}
