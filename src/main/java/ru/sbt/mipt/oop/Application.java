package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) {
        try{
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("smart-home-1.js");
            SensorEvent event = RandomSensorEvent.getNextSensorEvent();
            EventHandler.handleAllEvents(event, smartHome);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
