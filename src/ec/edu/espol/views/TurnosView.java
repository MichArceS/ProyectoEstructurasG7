package ec.edu.espol.views;

import ec.edu.espol.util.Video;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.util.Observable;
import java.util.Observer;


public class TurnosView implements Observer {

    private BorderPane root;
    private VBox sup;
    private Label bot;
    private VBox mid;
    private MediaView mediaView;
    private VBox boxPuestos;

    public TurnosView(Scene scene) {
        inicializarObjetos();
        crearEstructuraSuperior();
        crearEstructuraInferior();
        crearEstructuraMid();
        }

    private void inicializarObjetos() {
        root = new BorderPane();
        sup = new VBox();
        bot = new Label();
        mid = new VBox();
        mediaView = new MediaView();
        boxPuestos = new VBox();
    }

    private void crearEstructuraMid() {
        mid.getChildren().addAll(mediaView,boxPuestos);
    }

    private void crearEstructuraSuperior() {
        Image image = new Image("Ejemplo");
        ImageView imageView = new ImageView(image);
        imageView.setScaleX(50);
        imageView.setScaleY(50);
        Label label = new Label("Hora de ejemplo");
        sup.getChildren().addAll(imageView,label);
    }

    private void crearEstructuraInferior() {
        bot.setText("Bienvenidos! Los horarios de atención son: lunes a viernes de 6:00 -- 18:00");
    }

    private void setVideo(Video video) {
        Media media = video.getMedia();
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    private void añadirTurnos() {

    }

    @Override
    public void update(Observable observable, Object o) {
        Video video = (Video)o;
        setVideo(video);
    }
}
