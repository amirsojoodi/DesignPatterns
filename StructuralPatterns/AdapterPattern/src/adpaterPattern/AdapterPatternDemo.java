package adpaterPattern;

public class AdapterPatternDemo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        
        audioPlayer.play("mp3", "Shajarian-Sarv-e-Chaman.mp3");
        audioPlayer.play("mp4", "Homayoon-Chera-rafti.mp4");
        audioPlayer.play("vlc", "Keyhan-kalhor.vlc");
        audioPlayer.play("avi", "Homayoon-Khodavandan-e-Asrar.avi");
    }
}
