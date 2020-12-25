package ru.job4j.exam;

import java.net.URL;

public class Camera {
    private int id;
    private String urlType;
    private String videoUrl;
    private String value;
    private int ttl;

    public Camera(int id, String urlType, String videoUrl, String value, int ttl) {
        this.id = id;
        this.urlType = urlType;
        this.videoUrl = videoUrl;
        this.value = value;
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + id +
                ", urlType='" + urlType + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", value='" + value + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}
