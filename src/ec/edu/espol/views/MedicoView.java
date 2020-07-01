package ec.edu.espol.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicoView {
        VBox root;
        Label lblHora;
        Label lblNombreMedico;
        Button btnSgtTurno;
        Button btnCerrarSesion;

        public MedicoView () {
            crearEstructura();
        }

        public void crearEstructura(){
            root = new VBox();
            crearBotones();
            crearLabels();
            VBox row = new VBox();
            row.getChildren().addAll(btnSgtTurno,btnCerrarSesion);
            root.getChildren().addAll(lblHora,lblNombreMedico,row);
        }

        public void crearBotones(){
            btnSgtTurno = new Button("SIGUIENTE TURNO");
            btnCerrarSesion = new Button("CERRAR SESION");
        }
        public void crearLabels(){
            lblHora = new Label("12:30");
            lblNombreMedico = new Label("Nombre del Medico");
        }

        public VBox getRoot(){
            return root;
        }
}
