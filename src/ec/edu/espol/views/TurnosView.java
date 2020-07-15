package ec.edu.espol.views;

import ec.edu.espol.common.Turno;
import ec.edu.espol.main.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TurnosView {

    private BorderPane root;
    public static Label lblHora;
    private VBox sup;
    private HBox bot;
    private HBox mid;
    public static MediaView mediaView;
    private GridPane turnosGrid;
    private static LinkedList<Turno> turnosMostrar;
    private static List<Label> puestos;
    private static List<Label> turnos;

    public TurnosView() {
        turnosMostrar = new LinkedList<>();
        inicializarObjetos();
        crearEstructuraSuperior();
        crearEstructuraInferior();
        crearEstructuraMid();
        }

    private void inicializarObjetos() {
        root = new BorderPane();
        lblHora = new Label();
        lblHora.setId("lblHora");
        puestos = new LinkedList<>();
        turnos = new LinkedList<>();
        sup = new VBox();
        bot = new HBox();
        mid = new HBox();
        mid.setAlignment(Pos.CENTER);
        mediaView = new MediaView();
        turnosGrid = new GridPane();
        crearEstructuraTurnos();
        root.setTop(sup);
        root.setCenter(mid);
        root.setBottom(bot);
    }

    private void crearEstructuraMid() {
        mid.getChildren().addAll(mediaView, turnosGrid);
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
            MainScene.allowDrag();
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
        agregarListaPuestos(puesto1,puesto2,puesto3,puesto4);
        agregarListaTurnos(turno1,turno2,turno3,turno4);
        turnosGrid.setId("box-turnos");
        turnosGrid.setAlignment(Pos.CENTER);
        turnosGrid.setHgap(10);
        turnosGrid.setVgap(10);
        turnosGrid.setPadding(new Insets(25, 25, 25, 25));
        turnosGrid.add(turno,0,0);
        turnosGrid.add(puesto,1,0);
        turnosGrid.add(turno1,0,1);
        turnosGrid.add(puesto1,1,1);
        turnosGrid.add(turno2,0,2);
        turnosGrid.add(puesto2,1,2);
        turnosGrid.add(turno3,0,3);
        turnosGrid.add(puesto3,1,3);
        turnosGrid.add(turno4,0,4);
        turnosGrid.add(puesto4,1,4);
        actualizarTurnos();
    }

    public void agregarListaTurnos(Label t1,Label t2,Label t3,Label t4){
        turnos.add(t1);
        turnos.add(t2);
        turnos.add(t3);
        turnos.add(t4);
    }

    public void agregarListaPuestos(Label p1,Label p2,Label p3,Label p4){
        puestos.add(p1);
        puestos.add(p2);
        puestos.add(p3);
        puestos.add(p4);
    }

    public static void añadirTurnos(Turno turno) {
        if (turnosMostrar.size() < 4) turnosMostrar.addFirst(turno);
        else if (turnosMostrar.size() >= 4){
            turnosMostrar.remove(turnosMostrar.size()-1);
            turnosMostrar.addFirst(turno); }
        actualizarTurnos();
    }

    public static void actualizarTurnos(){
        Platform.runLater(()->{
            Iterator<Turno> i1= turnosMostrar.iterator();
            int n = 0;
            while(n<4){
                if(i1.hasNext()){
                    Turno t = i1.next();
                    turnos.get(n).setText("A0"+t.getTurnoAsignado());
                    puestos.get(n).setText("0"+t.getPuestoAsignado());
                }else{
                    turnos.get(n).setText("-");
                    puestos.get(n).setText("-");
                }
                n++;
            }
        });
    }
    public BorderPane getRoot() {
        return root;
    }
}
