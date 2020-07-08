package ec.edu.espol.util;

import ec.edu.espol.views.*;
import javafx.application.Platform;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora implements Runnable{

    Date objDate;
    boolean stop;

    public Hora() {
    }

    @Override
    public void run() {
        while(!stop) {
            Date objDate = new Date();
            String strDateFormat = "hh:mm:ss";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            Platform.runLater(()->{ConsultaView.lblHora.setText(objSDF.format(objDate));});
            Platform.runLater(()->{FormMedicoView.lblHora.setText(objSDF.format(objDate));});
            Platform.runLater(()->{FormPacienteView.lblHora.setText(objSDF.format(objDate));});
            Platform.runLater(()->{MedicoView.lblHora.setText(objSDF.format(objDate));});
            Platform.runLater(()->{LoginView.lblHora.setText(objSDF.format(objDate));});
            Platform.runLater(()->{MedicoView.lblHora.setText(objSDF.format(objDate));});
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        stop = true;
    }

}
