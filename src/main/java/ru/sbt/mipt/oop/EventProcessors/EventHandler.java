package ru.sbt.mipt.oop.EventProcessors;

import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class EventHandler {

    private final List<EventProcessor> processors;

    public EventHandler(List<EventProcessor> processors) {
        this.processors = processors;
    }

    public void handleAllEvents(SensorEvent event, SmartHome smartHome) throws Exception {
        while (event != null) {
            System.out.println("Got event: " + event);
            //event = RandomSensorEvent.getNextSensorEvent();
            for (EventProcessor processor: processors) {
                processor.processEvent(smartHome, event);
            }
            event = null;
        }
    }
}
