package ec.edu.espol.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PuestosView implements View{
    private BorderPane root;
    public static Label lblHora;
    private Label lblPuesto;
    private Button btnAsignarEditarPuesto;
    private Button btnEliminarPuesto;
    private Button btnNuevoPuesto;
    private Button btnCancelar;

    public PuestosView() {
        crearEstructura();
    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        crearLabels();
        GridPane center = new GridPane();
        center.setHgap(10);
        center.setVgap(10);
        center.setPadding(new Insets(25, 25, 25, 25));
        center.add(lblPuesto,0,0);
        center.add(btnNuevoPuesto,0,1);
        center.add(btnAsignarEditarPuesto,1,1);
        center.add(btnEliminarPuesto,2,1);
        lblHora.setAlignment(Pos.TOP_RIGHT);
        center.setAlignment(Pos.CENTER);
        btnCancelar.setAlignment(Pos.CENTER_LEFT);
        root.setTop(lblHora);
        root.setCenter(center);
        root.setBottom(btnCancelar);

    }

    private void crearBotones(){
        btnAsignarEditarPuesto = new Button("ASIGNAR/EDITAR");
        btnAsignarEditarPuesto.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.asignarEditarPuestoView.getRoot());
        });
        btnNuevoPuesto = new Button("NUEVO");
        btnNuevoPuesto.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.nuevoPuestoView.getRoot());
        });
        btnEliminarPuesto = new Button("ELIMINAR");
        btnEliminarPuesto.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.eliminarPuestoView.getRoot());
        });

        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
    }
    private void crearLabels(){
        lblHora = new Label("");
        lblHora.setId("lblHora");
        lblPuesto = new Label("Puesto");
    }

    public BorderPane getRoot(){
        return root;
    }
}
