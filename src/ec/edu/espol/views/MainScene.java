package ec.edu.espol.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainScene {
    static Stage primaryStage;
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
    private static double x=0;
    private static double y=0;

    public MainScene(Stage stage){
        primaryStage = stage;
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
        allowDrag();
        confirmStage = new ConfirmStage(stage);
    }

    protected static void allowDrag(){
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
                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);
            }
        });
    }




}
