package ru.bichevoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Camera {
    @Autowired
    @Qualifier("colorCameraRoll")
    private CameraRoll cameraRoll;
    @Value("${camera.brand}")
    private String brand;

    public Camera() {
    }


    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void makePhoto() {
        cameraRoll.doPhoto();
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void init() {

    }

    public void destroy() {

    }
}
