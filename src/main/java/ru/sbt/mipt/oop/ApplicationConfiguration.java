package ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.EventProcessors.*;
import ru.sbt.mipt.oop.command.MappedRemoteControl;

import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {
    @Bean
    SensorEventsManager sensorEventsManager() {
        return new SensorEventsManager();
    }

    @Bean
    SensorDecorator processorSensorDecorator(EventProcessor processor) {
        return new ProcessSensorDecorator(processor);
    }

    @Bean
    RemoteControl mapRemoteControl() {
        return new MappedRemoteControl();
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }
}
