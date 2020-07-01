package ec.edu.espol.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConsultaView {
    VBox root;
    Label lblPaciente;
    Label lblHora;
    Label lblNombre;
    Label lblEdad;
    Label lblGenero;
    Label lblSintoma;
    Label lblDiagnostico;
    Label lblReceta;
    TextField txtDiagnostico;
    TextField txtReceta;
    Button btnCancelar;
    Button btnTerminar;

    public ConsultaView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new VBox();
        crearBotones();
        creatTxtFields();
        crearLabels();
        HBox row1 = new HBox();
        row1.getChildren().addAll(lblPaciente,lblHora);
        HBox row3 = new HBox();
        row3.getChildren().addAll(lblEdad,lblGenero);
        HBox row4 = new HBox();
        VBox diag = new VBox();
        diag.getChildren().addAll(lblDiagnostico,txtDiagnostico);
        VBox rece = new VBox();
        rece.getChildren().addAll(lblReceta,txtReceta);
        row4.getChildren().addAll(diag,rece);
        HBox row5 = new HBox();
        row5.getChildren().addAll(btnCancelar,btnTerminar);
        root.getChildren().addAll(row1,lblNombre,row3,lblSintoma,row4,row5);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnTerminar = new Button("TERMINAR");
    }

    private void creatTxtFields(){
        txtDiagnostico = new TextField();
        txtDiagnostico.setPromptText("Escribir diagnostico");
        txtReceta = new TextField();
        txtReceta.setPromptText("Escribir Receta");
    }

    private void crearLabels(){
        lblPaciente = new Label("Paciente");
        lblHora = new Label("12:30");
        lblNombre = new Label("Josue Tomala");
        lblEdad = new Label("19");
        lblGenero = new Label("Masculino");
        lblSintoma = new Label("Ejemplo");
        lblDiagnostico = new Label("DIAGNOSTICO");
        lblReceta = new Label("RECETA");
        instanciarIDs();
    }

    public VBox getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblNombre.setId("lblNombre");
        lblEdad.setId("lblEdad");
        lblGenero.setId("lblGenero");
        lblSintoma.setId("lblSintoma");
        lblDiagnostico.setId("lblDiagnostico");
        lblReceta.setId("lblReceta");
        root.setId("consulta-view");
    }
}
