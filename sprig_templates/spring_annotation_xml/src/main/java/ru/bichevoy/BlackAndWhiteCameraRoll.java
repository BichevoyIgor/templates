package ru.bichevoy;

import org.springframework.stereotype.Component;

@Component
public class BlackAndWhiteCameraRoll implements CameraRoll{
    @Override
    public void doPhoto() {
        System.out.println("-1 черно-белый снимок");
    }
}
