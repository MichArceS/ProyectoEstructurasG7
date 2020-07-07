package ec.edu.espol.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class LoginView implements View{
    BorderPane root;
    Label lblInicioSesion;
    public static Label lblHora;
    Label lblUsuario;
    TextField txtUsuario;
    Label lblPassword;
    PasswordField txtPassword;
    Button btnCancelar;
    Button btnIniciarSesion;

    public LoginView(){
        crearEstructura();

    }

    private void crearEstructura(){
        root = new BorderPane();
        crearBotones();
        creatTxtFields();
        crearLabels();
        AnchorPane top = new AnchorPane();
        AnchorPane.setLeftAnchor(lblInicioSesion,10d);
        AnchorPane.setRightAnchor(lblHora,10d);
        top.getChildren().addAll(lblInicioSesion,lblHora);
        root.setTop(top);
        AnchorPane bottom = new AnchorPane();
        AnchorPane.setLeftAnchor(btnCancelar,10d);
        AnchorPane.setRightAnchor(btnIniciarSesion,10d);
        bottom.getChildren().addAll(btnCancelar,btnIniciarSesion);
        root.setBottom(bottom);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(lblUsuario,0,0);
        grid.add(txtUsuario,1,0);
        grid.add(lblPassword,0,1);
        grid.add(txtPassword,1,1);
        root.setCenter(grid);
    }

    private void crearBotones(){
        btnCancelar = new Button("CANCELAR");
        btnCancelar.setOnAction(e->{
            txtUsuario.clear();
            txtPassword.clear();
            MainScene.scene.setRoot(MainScene.inicio.getRoot());
        });
        btnIniciarSesion = new Button("INICIAR SESION");
        btnIniciarSesion.setOnAction(e->{
            txtUsuario.clear();
            txtPassword.clear();
            MainScene.scene.setRoot(MainScene.medicoView.getRoot());
        });
    }

    private void creatTxtFields(){
        txtUsuario = new TextField();
        txtPassword = new PasswordField();

    }

    private void crearLabels(){
        lblInicioSesion = new Label("Paciente");
        lblHora = new Label("12:30");
        lblUsuario = new Label("Usuario:");
        lblPassword = new Label("Contraseña: ");
        instanciarIDs();
    }

    public BorderPane getRoot(){
        return root;
    }

    private void instanciarIDs(){
        lblHora.setId("lblHora");
        lblInicioSesion.setId("lblPaciente");
        txtPassword.setId("lblPassword");
    }
}
