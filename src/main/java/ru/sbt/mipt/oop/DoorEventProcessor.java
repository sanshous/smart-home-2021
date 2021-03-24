package ru.sbt.mipt.oop;

public class DoorEventProcessor implements EventProcessor{
    public void  processEvent(SmartHome smartHome, SensorEvent event) throws Exception {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType().equals(SensorEventType.DOOR_OPEN)) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else if (event.getType().equals(SensorEventType.DOOR_CLOSED)) {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        if (room.getName().equals("hall")) {
                            HallDoorEventProcessor.processEvent(smartHome, event);
                        }
                    }
                } else {
                    throw new Exception("There's no such Id");
                }
            }
        }
    }
}
