package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.EventProcessors.*;

import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        try{
            SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("smart-home-1.js");
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor()
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
