package org.oop.oanquan.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class umad implements music{
    @Override
    public void play() {
        MediaPlayer mediaPlayer;
        String musicFile = "/org/oop/oanquan/resources/umad.mp3";
        // Play the selected music
        if (musicFile != null) {
            Media media = new Media(getClass().getResource(musicFile).toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
    }
}
