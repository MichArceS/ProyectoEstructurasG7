package ec.edu.espol.views;

import ec.edu.espol.main.Main;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioView implements View{
    VBox root;
    //Image image;
    Button btnTurnos;
    Button btnFormPaciente;
    Button btnSisMedico;
    Button btnFormMedico;
    Button btnSalir;

    public InicioView(){
        crearEstructura();
    }

    public void crearEstructura(){
        root = new VBox();
        crearBotones();
        VBox column1 = new VBox();
        column1.getChildren().addAll(btnTurnos,btnSisMedico );
        VBox column2 = new VBox();
        column2.getChildren().addAll(btnFormPaciente,btnFormMedico);
        HBox row1 = new HBox();
        row1.getChildren().addAll(column1,column2);
        row1.setAlignment(Pos.CENTER);
        HBox row2 = new HBox();
        row2.getChildren().addAll(btnSalir);
        row2.setAlignment(Pos.CENTER);
        root.getChildren().addAll(row1,row2);
        root.setAlignment(Pos.CENTER);
    }

    public void crearBotones(){
        // image = new Image();
        crearBtnTurno();
        crearBtnFormPaciente();
        crearBtnSisMedico();
        crearBtnCrearMedico();
        crearBtnSalir();
    }

    public void crearBtnTurno(){
        btnTurnos = new Button("TURNOS");
        btnTurnos.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.turnosView.getRoot());
            Main.videos.iniciarVideo();
        });
    }
    public void crearBtnFormPaciente(){
        btnFormPaciente = new Button("FORMULARIO PACIENTE");
        btnFormPaciente.setOnAction(e ->{
            Platform.runLater(()->{
                MainScene.scene.setRoot(MainScene.formPacienteView.getRoot());
            });
        });
    }
    public void crearBtnSisMedico(){
        btnSisMedico = new Button("SISTEMA MEDICO");
        btnSisMedico.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.loginView.getRoot());
        });
    }

    public void crearBtnCrearMedico(){
        btnFormMedico = new Button("AGREGAR MEDICO");
        btnFormMedico.setOnAction(e->{
            MainScene.scene.setRoot(MainScene.formMedicoView.getRoot());
        });
    }
    public void crearBtnSalir(){
        btnSalir = new Button("SALIR");
        btnSalir.setOnAction(e->{
            Platform.exit();
        });
    }

    public VBox getRoot(){
        return root;
    }
}
