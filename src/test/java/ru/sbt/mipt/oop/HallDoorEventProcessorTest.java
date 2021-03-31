package ru.sbt.mipt.oop;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.*;

import java.io.IOException;
import java.util.Arrays;

class HallDoorEventProcessorTest {

    @Test
    void processEventOpen() {
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "4");
            SensorDecorator decorator = new DoorEventProcessor();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
                    )
            );
            eventHandler.handleAllEvents(event, smartHome);
            boolean expected = true;
            boolean actual = false;
            for ( Room room: smartHome.getRooms() ) {
                for ( Door door: room.getDoors() ) {
                    if ( door.getId().equals("4") ) {
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
    void processEventClosed(){
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "4");
            SensorDecorator decorator = new DoorEventProcessor();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
                    )
            );
            eventHandler.handleAllEvents(event, smartHome);
            boolean expected = false;
            boolean actual = true;
            for ( Room room: smartHome.getRooms() ) {
                for ( Door door: room.getDoors() ) {
                    if ( door.getId().equals("4") ) {
                        actual = door.getIsOpen();
                    }
                }
                for ( Light light: room.getLights()) {
                    Assert.assertEquals(light.getIsOn(), false);
                }
            }
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}