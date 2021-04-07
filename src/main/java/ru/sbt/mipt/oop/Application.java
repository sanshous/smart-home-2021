package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.EventProcessors.*;

import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String... args) {
        try{
            SensorEventsManager sensorEventsManager = new SensorEventsManager();
            SensorDecorator decorator = new DoorEventProcessor();
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("smart-home-1.js");
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
                    ), smartHome
            );
            sensorEventsManager.registerEventHandler((com.coolcompany.smarthome.events.EventHandler) eventHandler);
            sensorEventsManager.start();
            SensorEvent event = RandomSensorEvent.getNextSensorEvent();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
