package ru.bichevoy;

import org.springframework.stereotype.Component;

@Component
public class ColorCameraRoll implements CameraRoll{
    @Override
    public void doPhoto() {
        System.out.println("-1 цветной снимок");
    }
}
