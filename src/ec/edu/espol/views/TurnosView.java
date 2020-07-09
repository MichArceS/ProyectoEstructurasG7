package ec.edu.espol.views;

import ec.edu.espol.main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

public class TurnosView {

    private BorderPane root;
    public static Label lblHora;
    private VBox sup;
    private HBox bot;
    private HBox mid;
    public static MediaView mediaView;
    private GridPane turnos;

    public TurnosView() {
        inicializarObjetos();
        crearEstructuraSuperior();
        crearEstructuraInferior();
        crearEstructuraMid();
        }

    private void inicializarObjetos() {
        root = new BorderPane();
        lblHora = new Label();
        lblHora.setId("lblHora");
        sup = new VBox();
        bot = new HBox();
        mid = new HBox();
        mid.setAlignment(Pos.CENTER);
        mediaView = new MediaView();
        turnos = new GridPane();
        crearEstructuraTurnos();
        root.setTop(sup);
        root.setCenter(mid);
        root.setBottom(bot);
    }

    private void crearEstructuraMid() {
        mid.getChildren().addAll(mediaView, turnos);
    }

    private void crearEstructuraSuperior() {
        sup.getChildren().addAll(lblHora);
    }

    private void crearEstructuraInferior() {
        Label l = new Label("Bienvenidos! Los horarios de atención son: lunes a viernes de 6:00 -- 18:00");
        Button boton = new Button("Volver");
        boton.setOnAction(e -> {
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
            Main.videos.mutearVideo();
        });
        bot.getChildren().addAll(boton,l);
    }

    public void crearEstructuraTurnos(){
        Label turno = new Label("TURNO");
        Label puesto = new Label("PUESTO");
        Label turno1 = new Label("A001");
        Label puesto1 = new Label("01");
        Label turno2 = new Label("A002");
        Label puesto2 = new Label("02");
        Label turno3 = new Label("A003");
        Label puesto3 = new Label("03");
        Label turno4 = new Label("A004");
        Label puesto4 = new Label("04");
        turno.setId("turno");
        puesto.setId("puesto");
        turno1.setId("turno");
        puesto1.setId("puesto");
        turno2.setId("turno");
        puesto2.setId("puesto");
        turno3.setId("turno");
        puesto3.setId("puesto");
        turno4.setId("turno");
        puesto4.setId("puesto");
        turnos.setId("box-turnos");
        turnos.setAlignment(Pos.CENTER);
        turnos.setHgap(10);
        turnos.setVgap(10);
        turnos.setPadding(new Insets(25, 25, 25, 25));
        turnos.add(turno,0,0);
        turnos.add(puesto,1,0);
        turnos.add(turno1,0,1);
        turnos.add(puesto1,1,1);
        turnos.add(turno2,0,2);
        turnos.add(puesto2,1,2);
        turnos.add(turno3,0,3);
        turnos.add(puesto3,1,3);
        turnos.add(turno4,0,4);
        turnos.add(puesto4,1,4);
    }

    private void añadirTurnos() {

    }

    public BorderPane getRoot() {
        return root;
    }
}
