package org.oop.oanquan.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class musicController{
//    protected String filePath;
    public flashbang flashbang = new flashbang();
    public ez ez = new ez();
    public ticking ticking = new ticking();
    public umad umad = new umad();
    public zedd zedd = new zedd();

    public void play(String musicChoice)  {
        // Determine the music file based on the selected choice
        String musicFile = null;
        switch (musicChoice) {
            case "EZ4ENCE":
                ez.play(); // Update with the actual path
                break;
            case "Flashbang Dance":
                flashbang.play(); // Update with the actual path
                break;
            case "Ticking Away":
                ticking.play();// Update with the actual path
                break;
            case "U mad !?":
                umad.play();// Update with the actual path
                break;
            case "Zedd":
                zedd.play();// Update with the actual path
                break;
        }
    }
}
