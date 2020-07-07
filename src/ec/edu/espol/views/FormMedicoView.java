package ec.edu.espol.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class FormMedicoView implements View{
    BorderPane root;
    Label lblFormMedico;
    public static Label lblHora;
    Label lblNombre;
    TextField txtNombre;
    Label lblApellido;
    TextField txtApellido;
    Label lblEdad;
    TextField txtEdad;
    Label lblGenero;
    TextField txtGenero;
    Label lblEspecialidad;
    ComboBox comboEspecialidad;
    Label lblUsuario;
    TextField txtUsuario;
    Label lblPassword;
    PasswordField txtPassword;
    Button btnCancelar;
    Button btnTerminar;

    public FormMedicoView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        creatTxtFields();
        crearLabels();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblFormMedico,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblFormMedico,lblHora);
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
        grid.add(lblUsuario,0,5);
        grid.add(txtUsuario,1,5);
        grid.add(lblPassword,0,6);
        grid.add(txtPassword,1,6);
        root.setCenter(grid);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            txtNombre.clear();
            txtApellido.clear();
            txtGenero.clear();
            txtEdad.clear();
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
        btnTerminar = new Button("TERMINAR");
        btnTerminar.setOnAction(e->{
            txtNombre.clear();
            txtApellido.clear();
            txtGenero.clear();
            txtEdad.clear();
            txtPassword.clear();
            txtUsuario.clear();
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
    }

    private void creatTxtFields(){
        txtEdad = new TextField();
        txtGenero = new TextField();
        txtNombre = new TextField();
        txtApellido = new TextField();
        txtUsuario = new TextField();
        txtPassword = new PasswordField();

    }

    private void crearLabels(){
        lblFormMedico = new Label("Formulario Medico");
        lblHora = new Label("12:30");
        lblNombre = new Label("Nombre:");
        lblApellido = new Label("Apellido: ");
        lblEdad = new Label("Edad:");
        lblGenero = new Label("Genero:");
        lblUsuario = new Label("Usuario:");
        lblEspecialidad = new Label("Especialidad: ");
        lblPassword = new Label("Contraseña: ");
        instanciarIDs();
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblFormMedico.setId("lblPaciente");
        txtPassword.setId("lblPassword");
    }
}
