package ru.sbt.mipt.oop.EventProcessors;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class EventHandler {

    private final SmartHome smartHome;

    private final List<EventProcessor> processors;

    public EventHandler(List<EventProcessor> processors, SmartHome smartHome) {
        this.processors = processors;
        this.smartHome = smartHome;
    }

    public void handleEvent(SensorEvent event) {
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor: processors) {
                try {
                    processor.processEvent(smartHome, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            event = RandomSensorEvent.getNextSensorEvent();
        }
    }
}
