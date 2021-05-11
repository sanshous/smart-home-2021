package ru.sbt.mipt.oop;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LightEventProcessorTest {

    @Test
    void processEvent() {
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "4");
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor()
                    )
            );
            eventHandler.handleAllEvents(event, smartHome);
            boolean expected = true;
            boolean actual = false;
            for ( Room room: smartHome.getRooms() ) {
                for ( Light light: room.getLights() ) {
                    if ( light.getId().equals("4") ) {
                        actual = light.getIsOn();
                    }
                }
            }
            Assert.assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void processEventNoId() throws Exception{
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "10");
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor()
                    )
            );
            eventHandler.handleAllEvents(event, smartHome);
        } catch (Exception e) {
            assertEquals("There's no such Id", e.getMessage());
        }
    }
}