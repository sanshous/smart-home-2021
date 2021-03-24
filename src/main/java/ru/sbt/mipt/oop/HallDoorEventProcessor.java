package ru.sbt.mipt.oop;

public class HallDoorEventProcessor {
    public static void processEvent(SmartHome smartHome, SensorEvent sensorEvent){
        for (Room homeRoom : smartHome.rooms) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandMessage.sendCommand(command);
            }
        }
    }
}
