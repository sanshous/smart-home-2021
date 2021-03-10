package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) {
        try{
            SmartHome smartHome = JsonToSmartHome("smart-home-1.js");
            SensorEvent event = getNextSensorEvent();
            while (event != null) {
                System.out.println("Got event: " + event);
                changeSmartHome c = changeSmartHome.valueOf(event.getType().getValue());
                c.changeSmartHomeWithEvent(smartHome, event);
                event = getNextSensorEvent();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }

    private static SmartHome JsonToSmartHome(String Filename) throws IOException{
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(Filename)));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }

    private enum changeSmartHome {
        LIGHT_ON {
            void changeSmartHomeWithEvent(SmartHome smartHome, SensorEvent event) throws Exception {
                SmartHome.changeThing c = SmartHome.changeThing.LIGHT;
                RoomAndThing changedRoomAndThing = c.changeThingSmartHome(event.getObjectId(), true, smartHome);
                if (changedRoomAndThing == null) {
                    throw new Exception("There's no such Id");
                }
                System.out.println("Light " + changedRoomAndThing.getThing().
                        getId() + " in room " + changedRoomAndThing.getRoom().

                        getName() + " was turned on.");
            }
            },
            LIGHT_OFF {
            void changeSmartHomeWithEvent(SmartHome smartHome, SensorEvent event) throws Exception {
                    SmartHome.changeThing c = SmartHome.changeThing.LIGHT;
                    RoomAndThing changedRoomAndThing = c.changeThingSmartHome(event.getObjectId(), false, smartHome);
                    if (changedRoomAndThing == null) {
                        throw new Exception("There's no such Id");
                    }
                    System.out.println("Light " + changedRoomAndThing.getThing().

                            getId() + " in room " + changedRoomAndThing.getRoom().

                            getName() + " was turned off.");
                }
            },
            DOOR_OPEN {
                void changeSmartHomeWithEvent(SmartHome smartHome, SensorEvent event) throws Exception {
                    SmartHome.changeThing c = SmartHome.changeThing.DOOR;
                    RoomAndThing changedRoomAndThing = c.changeThingSmartHome(event.getObjectId(), true, smartHome);
                    if (changedRoomAndThing == null) {
                        throw new Exception("There's no such Id");
                    }
                    System.out.println("Door " + changedRoomAndThing.getThing().

                            getId() + " in room " + changedRoomAndThing.getRoom().

                            getName() + " was opened.");
                }
            },
            DOOR_CLOSED {
                void changeSmartHomeWithEvent(SmartHome smartHome, SensorEvent event) throws Exception {
                    SmartHome.changeThing c = SmartHome.changeThing.DOOR;
                    RoomAndThing changedRoomAndThing = c.changeThingSmartHome(event.getObjectId(), false, smartHome);
                    if (changedRoomAndThing == null) {
                        throw new Exception("There's no such Id");
                    }
                    System.out.println("Door " + changedRoomAndThing.getThing().

                            getId() + " in room " + changedRoomAndThing.getRoom().

                            getName() + " was closed.");
                    if (changedRoomAndThing.getRoom().

                            getName().

                            equals("hall")) {
                        for (Room homeRoom : smartHome.rooms) {
                            for (Light light : homeRoom.getLights()) {
                                SmartHome.changeThing a = SmartHome.changeThing.LIGHT;
                                RoomAndThing changeThingSmart = a.changeThingSmartHome(light.getId(), false, smartHome);
                                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                sendCommand(command);
                            }
                        }
                    }
                }
            };

            abstract void changeSmartHomeWithEvent(SmartHome smartHome, SensorEvent event) throws Exception;
        }
}
