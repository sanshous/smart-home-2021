package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.EventProcessors.SensorEvent;

public class Adapter implements EventHandler {
    private ru.sbt.mipt.oop.EventProcessors.EventHandler eventHandler;

    public  Adapter(ru.sbt.mipt.oop.EventProcessors.EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
    @Override
    public void handleEvent(CCSensorEvent event) {
        eventHandler.handleEvent(remakeCCSensorEvent(event));
    }

    private SensorEvent remakeCCSensorEvent(CCSensorEvent event) {
        for (SensorEventType type : SensorEventType.values()) {
            if (type.getValue().equals(event.getEventType())) {
                return new SensorEvent(type, event.getObjectId());
            }
        }
        return null;
    }
}
