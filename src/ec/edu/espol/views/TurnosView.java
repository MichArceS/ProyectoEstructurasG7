package ec.edu.espol.views;

import ec.edu.espol.util.Video;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class TurnosView {

    private BorderPane root;
    public static Label lblHora;
    private VBox sup;
    private HBox bot;
    private VBox mid;
    public static MediaView mediaView;
    private VBox boxPuestos;

    public TurnosView() {
        inicializarObjetos();
        crearEstructuraSuperior();
        crearEstructuraInferior();
        crearEstructuraMid();
        }

    private void inicializarObjetos() {
        root = new BorderPane();
        lblHora = new Label();
        sup = new VBox();
        bot = new HBox();
        mid = new VBox();
        mediaView = new MediaView();
        boxPuestos = new VBox();
        root.setTop(sup);
        root.setCenter(mid);
        root.setBottom(bot);
    }

    private void crearEstructuraMid() {
        mid.getChildren().addAll(mediaView,boxPuestos);
    }

    private void crearEstructuraSuperior() {
        //Image image = new Image("Ejemplo");
        //ImageView imageView = new ImageView(image);
        //imageView.setScaleX(50);
        //imageView.setScaleY(50);
        sup.getChildren().addAll(lblHora);
    }

    private void crearEstructuraInferior() {
        Label l = new Label("Bienvenidos! Los horarios de atención son: lunes a viernes de 6:00 -- 18:00");
        Button boton = new Button("Volver");
        boton.setOnAction(e -> {
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
        bot.getChildren().addAll(boton,l);
    }

    public static void setVideo() {
        String s = new File("src/ec/edu/espol/media/patricio.mp4").getAbsolutePath();
        Media media = new Media((new File(s).toURI().toString()));
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaView.setMediaPlayer(mediaPlayer);
    }

    private void añadirTurnos() {

    }

    public BorderPane getRoot() {
        return root;
    }
}
