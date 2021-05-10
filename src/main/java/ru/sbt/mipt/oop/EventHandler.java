package ru.sbt.mipt.oop;

import java.util.List;

public class EventHandler {

    private final List<EventProcessor> processors;

    public EventHandler(List<EventProcessor> processors) {
        this.processors = processors;
    }

    public void handleAllEvents(SensorEvent event, SmartHome smartHome) throws Exception {
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor: processors) {
                processor.processEvent(smartHome, event);
            }
            event = RandomSensorEvent.getNextSensorEvent();
        }
    }
}
