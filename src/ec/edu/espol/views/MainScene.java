package ec.edu.espol.views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene {
    Scene scene;

    public MainScene(Stage stage){
        InicioView inicio = new InicioView();
        MedicoView medicoView = new MedicoView();
        scene = new Scene(medicoView.getRoot(),1000,600);
        stage.setTitle("INICIO");
        stage.setScene(scene);
    }
}
