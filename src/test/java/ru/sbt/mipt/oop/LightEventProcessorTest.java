package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.EventProcessors.*;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LightEventProcessorTest {

    @Test
    void processEvent() {
        try {
            SmartHome smartHome = JsonToSmartHome.getSmarthomeFromJson("output.js");
            CCSensorEvent event = new CCSensorEvent(SensorEventType.LIGHT_ON.getValue(), "4");
            SensorDecorator decorator = new DoorEventProcessor();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
                    ), smartHome
            );
            eventHandler.handleEvent(event);
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
            CCSensorEvent event = new CCSensorEvent(SensorEventType.LIGHT_ON.getValue(), "10");
            SensorDecorator decorator = new DoorEventProcessor();
            EventHandler eventHandler = new EventHandler(
                    Arrays.asList(
                            new LightEventProcessor(decorator),
                            new DoorEventProcessor(),
                            new HallDoorEventProcessor(decorator)
                    ), smartHome
            );
            eventHandler.handleEvent(event);
        } catch (Exception e) {
            assertEquals("There's no such Id", e.getMessage());
        }
    }
}