package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessors.*;

import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String... args) {
        try{
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("smart-home-1.js");
            SensorEvent event = RandomSensorEvent.getNextSensorEvent();
            SensorDecorator decorator = new DoorEventProcessor();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
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
