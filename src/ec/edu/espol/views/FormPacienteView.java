package ec.edu.espol.views;

import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class FormPacienteView implements View{
    BorderPane root;
    Label lblFormPaciente;
    public static Label lblHora;
    Label lblNombre;
    TextField txtNombre;
    Label lblApellido;
    TextField txtApellido;
    Label lblEdad;
    TextField txtEdad;
    Label lblGenero;
    ComboBox comboGenero;
    Label lblSintoma;
    ComboBox comboSintoma;
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
        crearComboBoxs();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblFormPaciente,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblFormPaciente,lblHora);
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
        grid.add(comboGenero,1,3);
        grid.add(lblSintoma,0,4);
        grid.add(comboSintoma,1,4);
        grid.add(lblEspecialidad,0,5);
        grid.add(comboEspecialidad,1,5);
        root.setCenter(grid);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            txtNombre.clear();
            txtApellido.clear();
            txtEdad.clear();
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
        btnTerminar = new Button("TERMINAR");
        btnTerminar.setOnAction(e->{
            txtNombre.clear();
            txtApellido.clear();
            txtEdad.clear();
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
    }

    private void creatTxtFields(){
        txtEdad = new TextField();
        txtNombre = new TextField();
        txtApellido = new TextField();


    }

    private void crearLabels(){
        lblFormPaciente = new Label("Formulario Paciente");
        lblHora = new Label("12:30");
        lblNombre = new Label("Nombre:");
        lblApellido = new Label("Apellido: ");
        lblEdad = new Label("Edad:");
        lblGenero = new Label("Genero:");
        lblSintoma = new Label("Sintoma:");
        lblEspecialidad = new Label("Especialidad");
        instanciarIDs();
    }

    private void crearComboBoxs(){
        ObservableList lista = FXCollections.observableArrayList("1","2","3");
        comboGenero = new ComboBox(FXCollections.observableArrayList(Genero.values()));
        comboSintoma = new ComboBox(lista);
        comboEspecialidad = new ComboBox(FXCollections.observableArrayList(Especialidad.values()));
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblFormPaciente.setId("lblPaciente");
    }
}
