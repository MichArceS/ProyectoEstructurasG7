package ec.edu.espol.main;

import ec.edu.espol.views.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainScene mainScene = new MainScene(primaryStage);
        setUserAgentStylesheet("/ec/edu/espol/styles/StyleSheet.css");
        primaryStage.show();
    }
}
