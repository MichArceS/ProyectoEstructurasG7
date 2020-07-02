package ec.edu.espol.util;

import java.time.LocalDateTime;

public class Hora implements Runnable{

    LocalDateTime localDateTime;
    int hora;
    int minuto;
    int segundo;
    boolean stop;

    public Hora() {
        localDateTime = LocalDateTime.now();
        hora = localDateTime.getHour();
        minuto = localDateTime.getMinute();
        segundo = localDateTime.getSecond();
    }

    @Override
    public void run() {
        while(!stop) {
            segundo ++;
            if (segundo >= 60) {
                minuto ++;
                segundo = 0;
                if (minuto >= 60) {
                    hora ++;
                    minuto = 0;
                }
            }
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
