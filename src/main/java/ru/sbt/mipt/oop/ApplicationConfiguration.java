package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.EventProcessors.*;
import ru.sbt.mipt.oop.command.Command;
import ru.sbt.mipt.oop.command.MappedRemoteControl;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {
    @Bean
    SensorEventsManager sensorEventsManager() {
        return new SensorEventsManager();
    }

    @Bean
    ProcessSensorDecorator processSensorDecorator(SensorDecorator decorator) {
        return new ProcessSensorDecorator(decorator);
    }

    @Bean
    RemoteControl mapRemoteControl(Map<String, Command> commandMap) {
        return new MappedRemoteControl(commandMap);
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry(RemoteControl remoteControl) {
        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();
        remoteControlRegistry.registerRemoteControl(remoteControl, "id");
        return remoteControlRegistry;
    }
}
