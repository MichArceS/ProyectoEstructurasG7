package ec.edu.espol.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class FormPacienteView {
    BorderPane root;
    Label lblPaciente;
    Label lblHora;
    Label lblNombre;
    TextField txtNombre;
    Label lblApellido;
    TextField txtApellido;
    Label lblEdad;
    TextField txtEdad;
    Label lblGenero;
    TextField txtGenero;
    Label lblSintoma;
    TextField txtSintoma;
    Label lblEspecialidad;
    ComboBox comboEspecialidad;
    Button btnCancelar;
    Button btnTerminar;

    public FormPacienteView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        creatTxtFields();
        crearLabels();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblPaciente,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblPaciente,lblHora);
        root.setTop(top);
        AnchorPane bottom = new AnchorPane();
        AnchorPane.setLeftAnchor(btnCancelar,10d);
        AnchorPane.setRightAnchor(btnTerminar,10d);
        bottom.getChildren().addAll(btnCancelar,btnTerminar);
        root.setBottom(bottom);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(lblNombre,0,0);
        grid.add(txtNombre,1,0);
        grid.add(lblApellido,0,1);
        grid.add(txtApellido,1,1);
        grid.add(lblEdad,0,2);
        grid.add(txtEdad,1,2);
        grid.add(lblGenero,0,3);
        grid.add(txtGenero,1,3);
        grid.add(lblEspecialidad,0,4);
        ObservableList lista = FXCollections.observableArrayList("1","2","3");
        comboEspecialidad = new ComboBox(lista);
        grid.add(comboEspecialidad,1,4);
        root.setCenter(grid);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnTerminar = new Button("TERMINAR");
    }

    private void creatTxtFields(){
        txtEdad = new TextField();
        txtGenero = new TextField();
        txtNombre = new TextField();
        txtApellido = new TextField();
        txtSintoma = new TextField();

    }

    private void crearLabels(){
        lblPaciente = new Label("Paciente");
        lblHora = new Label("12:30");
        lblNombre = new Label("Nombre:");
        lblApellido = new Label("Apellido: ");
        lblEdad = new Label("Edad:");
        lblGenero = new Label("Genero:");
        lblSintoma = new Label("Sintoma:");
        lblEspecialidad = new Label("Especialidad");
        instanciarIDs();
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblPaciente.setId("lblPaciente");
    }
}
