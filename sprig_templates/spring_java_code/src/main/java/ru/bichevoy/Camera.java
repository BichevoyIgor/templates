package ru.bichevoy;

import org.springframework.beans.factory.annotation.Value;

public class Camera {

    private CameraRoll cameraRoll;
    @Value("${camera.brand}")
    private String brand;

    public Camera() {
    }

    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void makePhoto(){
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

    // метод, который сработает при создании бина
    public void init(){

    }

    // метод, который сработает только для singleton при context.close()
    public void destroy(){

    }

}
