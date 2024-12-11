package ru.bichevoy;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("context.properties")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Camera camera(){
        return new Camera(colorCameraRoll());
    }

    @Bean
    @Scope("prototype")
    public CameraRoll colorCameraRoll(){
        return new ColorCameraRoll();
    }
}
