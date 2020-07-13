package ec.edu.espol.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainScene {
    static Scene scene;
    static InicioView inicio;
    static MedicoView medicoView;
    static ConsultaView consultaView;
    static FormPacienteView formPacienteView;
    static FormMedicoView formMedicoView;
    static LoginView loginView;
    static TurnosView turnosView;
    static PuestosView puestosView;
    static NuevoPuestoView nuevoPuestoView;
    static AsignarEditarPuestoView asignarEditarPuestoView;
    static EliminarPuestoView eliminarPuestoView;
    static DesasignarPuestoView desasignarPuestoView;
    static ConfirmStage confirmStage;
    private double x=0;
    private double y=0;

    public MainScene(Stage stage){
        inicio = new InicioView();
        medicoView = new MedicoView();
        consultaView = new ConsultaView();
        formPacienteView = new FormPacienteView();
        formMedicoView = new FormMedicoView();
        loginView = new LoginView();
        turnosView = new TurnosView();
        puestosView = new PuestosView();
        nuevoPuestoView = new NuevoPuestoView();
        asignarEditarPuestoView = new AsignarEditarPuestoView();
        eliminarPuestoView = new EliminarPuestoView();
        desasignarPuestoView = new DesasignarPuestoView();
        scene = new Scene(inicio.getRoot(),1200,600);
        stage.setTitle("INICIO");
        stage.setScene(scene);
        allowDrag(stage);
        confirmStage = new ConfirmStage(stage);
    }

    private void allowDrag(Stage stage){
        scene.getRoot().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        scene.getRoot().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
    }




}
