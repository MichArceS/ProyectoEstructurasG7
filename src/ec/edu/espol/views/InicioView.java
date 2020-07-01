package ec.edu.espol.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioView {
    VBox root;
    //Image image;
    Button btnTurnos;
    Button btnFormPaciente;
    Button btnSisMedico;
    Button btnCrearMedico;
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
        column2.getChildren().addAll(btnFormPaciente,btnCrearMedico);
        HBox row1 = new HBox();
        row1.getChildren().addAll(column1,column2);
        HBox row2 = new HBox();
        row2.getChildren().addAll(btnSalir);
        root.getChildren().addAll(row1,row2);
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
    }
    public void crearBtnFormPaciente(){
        btnFormPaciente = new Button("FORMULARIO PACIENTE");

    }
    public void crearBtnSisMedico(){
        btnSisMedico = new Button("SISTEMA MEDICO");
    }

    public void crearBtnCrearMedico(){
        btnCrearMedico = new Button("AGREGAR MEDICO");
    }
    public void crearBtnSalir(){
        btnSalir = new Button("SALIR");
    }

    public VBox getRoot(){
        return root;
    }
}
