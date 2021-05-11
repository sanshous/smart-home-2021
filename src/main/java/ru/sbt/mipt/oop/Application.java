package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String... args) {
        try{
            JsonToSmartHome jsonToSmartHome = new JsonToSmartHome();
            SmartHome smartHome = jsonToSmartHome.getSmarthomeFromFile("smart-home-1.js");
            SensorEvent event = RandomSensorEvent.getNextSensorEvent();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor()
                    )
            );
            eventHandler.handleAllEvents(event, smartHome);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
