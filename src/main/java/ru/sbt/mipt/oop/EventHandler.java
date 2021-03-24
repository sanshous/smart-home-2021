package ru.sbt.mipt.oop;

public class EventHandler {
    public static void handleAllEvents(SensorEvent event, SmartHome smartHome) throws Exception {
        while (event != null) {
            System.out.println("Got event: " + event);
            event = RandomSensorEvent.getNextSensorEvent();
            if (event.getType().equals(SensorEventType.LIGHT_ON) || event.getType().equals(SensorEventType.LIGHT_OFF)){
                LightEventProcessor lightEventProcessor = new LightEventProcessor();
                lightEventProcessor.processEvent(smartHome, event);
            } else if (event.getType().equals(SensorEventType.DOOR_CLOSED) ||
            event.getType().equals(SensorEventType.DOOR_OPEN)) {
                DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
                doorEventProcessor.processEvent(smartHome, event);
            }
        }
    }
}
