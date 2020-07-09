package ec.edu.espol.util;

import ec.edu.espol.views.TurnosView;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Iterator;

public class hiloVideos implements Runnable{

    CircularSimplyLinkedList<Video> CSLL;
    private boolean stop;

    public hiloVideos(CircularSimplyLinkedList<Video> c) {
        CSLL = c;
    }

    @Override
    public void run() {
        Iterator<Video> it = CSLL.iterator();
        while (!stop) {
            Video video = it.next();
            System.out.println(video);
            String s = new File(video.getMedia()).getAbsolutePath();
            Media media = new Media((new File(s).toURI().toString()));
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            Long tiempo = video.getDuracion();
            mediaPlayer.play();
            Platform.runLater(() -> {TurnosView.mediaView.setMediaPlayer(mediaPlayer);});
            System.out.println(tiempo);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        stop = true;
    }
}
