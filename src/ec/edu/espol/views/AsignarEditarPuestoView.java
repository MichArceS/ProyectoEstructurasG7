package ec.edu.espol.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class AsignarEditarPuestoView {
    private BorderPane root;
    private Label lblInicioSesion;
    public static Label lblHora;
    private Label lblPuesto;
    private ComboBox txtPuesto;
    private Label lblMedico;
    private ComboBox txtMedico;
    private Button btnCancelar;
    private Button btnAgregarPuesto;

    public AsignarEditarPuestoView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        crearComboBox();
        crearLabels();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblInicioSesion,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblInicioSesion,lblHora);
        root.setTop(top);
        AnchorPane bottom = new AnchorPane();
        AnchorPane.setLeftAnchor(btnCancelar,10d);
        AnchorPane.setRightAnchor(btnAgregarPuesto,10d);
        bottom.getChildren().addAll(btnCancelar,btnAgregarPuesto);
        root.setBottom(bottom);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(lblPuesto,0,0);
        grid.add(txtPuesto,1,0);
        grid.add(lblMedico,0,1);
        grid.add(txtMedico,1,1);
        root.setCenter(grid);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.puestosView.getRoot());
        });
        btnAgregarPuesto = new Button("REASIGNAR PUESTO");
        btnAgregarPuesto.setOnAction(e->{
            if(MainScene.confirmStage.confirmar("reasignar el puesto?")) {
                MainScene.scene.setRoot(MainScene.puestosView.getRoot());
            }
        });
    }

    private void crearComboBox(){
        txtPuesto = new ComboBox();
        txtMedico = new ComboBox();

    }

    private void crearLabels(){
        lblInicioSesion = new Label("Reasignar Puesto");
        lblHora = new Label("12:30");
        lblPuesto = new Label("Puesto:");
        lblMedico = new Label("Medico Asignado: ");
        instanciarIDs();
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblInicioSesion.setId("lblPaciente");
    }
}
