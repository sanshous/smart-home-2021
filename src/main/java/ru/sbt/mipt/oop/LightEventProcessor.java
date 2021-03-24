package ru.sbt.mipt.oop;

public class LightEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) throws Exception{
        for (Room room : smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType().equals(SensorEventType.LIGHT_ON)) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    }
                    else if (event.getType().equals(SensorEventType.LIGHT_OFF)) {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                } else {
                    throw new Exception("There's no such Id");
                }
            }
        }
    }
}
