package ec.edu.espol.util;

import javafx.scene.media.Media;

public class Video {

    private String nombre;
    private Media media;

    public Video(String n, String uri) {
        nombre = n;
        media = new Media(uri);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
