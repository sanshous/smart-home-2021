package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SmartHome;

public class ProcessSensorDecorator implements EventProcessor {
    private EventProcessor wrappee;

    ProcessSensorDecorator(EventProcessor wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent sensorEvent) throws Exception {
        wrappee.processEvent(smartHome, sensorEvent);
    }
}
