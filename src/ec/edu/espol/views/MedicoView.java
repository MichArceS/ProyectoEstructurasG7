package ec.edu.espol.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MedicoView implements View{
    private BorderPane root;
    public static Label lblHora;
    private Label lblNombreMedico;
    private Button btnSgtTurno;
    private Button btnCerrarSesion;

        public MedicoView () {
            crearEstructura();

        }

        private void crearEstructura(){
            root = new BorderPane();
            crearBotones();
            crearLabels();
            AnchorPane rowBottom = new AnchorPane();
            AnchorPane.setLeftAnchor(btnCerrarSesion,250d);
            AnchorPane.setRightAnchor(btnSgtTurno ,250d);
            rowBottom.getChildren().addAll(btnCerrarSesion,btnSgtTurno);
            VBox center = new VBox();
            center.getChildren().addAll(lblNombreMedico,rowBottom);
            VBox hora = new VBox(lblHora);
            hora.setAlignment(Pos.CENTER_RIGHT);
            center.setAlignment(Pos.CENTER);
            root.setTop(hora);
            root.setCenter(center);

        }

        private void crearBotones(){
            btnSgtTurno = new Button("SIGUIENTE TURNO");
            btnSgtTurno.setOnAction(e->{
                MainScene.scene.setRoot(MainScene.consultaView.getRoot());
            });
            btnCerrarSesion = new Button("CERRAR SESION");
            btnCerrarSesion.setOnAction(e->{
                if(MainScene.confirmStage.confirmar("cerrar sesion?")) {
                    MainScene.scene.setRoot(MainScene.inicio.getRoot());
                }
            });
        }
        private void crearLabels(){
            lblHora = new Label("");
            lblHora.setId("lblHora");
            lblNombreMedico = new Label("Nombre del Medico");
            lblNombreMedico.setId("lblNombreMedico");

        }

        public BorderPane getRoot(){
            return root;
        }
}
