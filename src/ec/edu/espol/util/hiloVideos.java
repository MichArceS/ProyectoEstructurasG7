package ec.edu.espol.util;

import ec.edu.espol.views.TurnosView;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Iterator;

public class hiloVideos implements Runnable{

    CircularSimplyLinkedList<Video> CSLL;
    private boolean stop;

    public hiloVideos(CircularSimplyLinkedList<Video> c) {
        CSLL = c;
    }

    @Override
    public void run() {
        while (!stop) {
            Iterator<Video> it = CSLL.iterator();
            Video video = it.next();
            Media media = video.getMedia();
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            System.out.println("F");
            Platform.runLater(() -> {TurnosView.mediaView.setMediaPlayer(mediaPlayer);});
            System.out.println("F2");
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        stop = true;
    }
}
