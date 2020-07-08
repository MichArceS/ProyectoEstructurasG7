package ec.edu.espol.main;

import ec.edu.espol.constants.Constantes;
import ec.edu.espol.system.SysData;
import ec.edu.espol.util.Hora;
import ec.edu.espol.views.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static Hora hora = new Hora();
    public static Thread hilo= new Thread(hora);
    MainScene mainScene;
    SysData sysData;


    @Override
    public void stop() throws Exception {
        hilo.stop();
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene = new MainScene(primaryStage);
        sysData = new SysData();
        hilo.start();
        setUserAgentStylesheet(Constantes.RUTASTYLE);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
