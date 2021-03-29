package ru.sbt.mipt.oop;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DoorEventProcessorTest {

    @Test
    void processEvent() {
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "2");
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
                for ( Door door: room.getDoors() ) {
                    if ( door.getId().equals("2") ) {
                        actual = door.getIsOpen();
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
            SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "10");
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