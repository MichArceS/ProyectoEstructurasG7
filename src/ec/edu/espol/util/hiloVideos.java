package ec.edu.espol.util;

public class hiloVideos implements  Runnable{

    CircularSimplyLinkedList CSLL = new CircularSimplyLinkedList();
    private boolean stop;

    public hiloVideos(CircularSimplyLinkedList c) {
        CSLL = c;
    }

    @Override
    public void run() {
        while (!stop) {

        }
    }

    public void stopThread() {
        stop = true;
    }
}
