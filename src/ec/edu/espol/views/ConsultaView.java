package ec.edu.espol.views;

import ec.edu.espol.main.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConsultaView implements View{
    BorderPane root;
    Label lblConsulta;
    public static Label lblHora;
    Label lblNombre;
    Label lblEdad;
    Label lblGenero;
    Label lblSintoma;
    Label lblDiagnostico;
    Label lblReceta;
    TextArea txtDiagnostico;
    TextArea txtReceta;
    Button btnCancelar;
    Button btnTerminar;

    public ConsultaView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        creatTxtFields();
        crearLabels();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblConsulta,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblConsulta,lblHora);
        root.setTop(top);
        AnchorPane bottom = new AnchorPane();
        AnchorPane.setLeftAnchor(btnCancelar,10d);
        AnchorPane.setRightAnchor(btnTerminar,10d);
        bottom.getChildren().addAll(btnCancelar,btnTerminar);
        root.setBottom(bottom);
        HBox row1 = new HBox();
        row1.getChildren().addAll(lblEdad,lblGenero);
        VBox diag = new VBox();
        diag.getChildren().addAll(lblDiagnostico,txtDiagnostico);
        VBox rece = new VBox();
        rece.getChildren().addAll(lblReceta,txtReceta);
        VBox info = new VBox();
        info.getChildren().addAll(lblNombre,row1,lblSintoma);
        BorderPane center = new BorderPane();
        center.setTop(info);
        center.setLeft(diag);
        center.setRight(rece);
        root.setCenter(center);


    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            txtDiagnostico.clear();
            txtReceta.clear();
            MainScene.scene.setRoot(MainScene.medicoView.getRoot());
        });
        btnTerminar = new Button("TERMINAR");
        btnTerminar.setOnAction(e->{
            txtDiagnostico.clear();
            txtReceta.clear();
            MainScene.scene.setRoot(MainScene.medicoView.getRoot());
        });
    }

    private void creatTxtFields(){
        txtDiagnostico = new TextArea();
        txtDiagnostico.setPromptText("Escribir diagnostico");
        txtDiagnostico.setWrapText(true);
        txtReceta = new TextArea();
        txtReceta.setPromptText("Escribir Receta");
        txtReceta.setWrapText(true);
    }

    private void crearLabels(){
        lblConsulta = new Label("Consulta");
        lblHora = new Label("");
        lblNombre = new Label("Nombre: Josue Tomala");
        lblEdad = new Label("Edad: 19");
        lblGenero = new Label("Genero: Masculino");
        lblSintoma = new Label("Sintoma: jemplo");
        lblDiagnostico = new Label("DIAGNOSTICO");
        lblReceta = new Label("RECETA");
        instanciarIDs();
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblConsulta.setId("lblPaciente");
        txtReceta.setId("txtReceta");
        txtDiagnostico.setId("txtDiagnostico");
    }
}
