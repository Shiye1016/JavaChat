package Javachat.clientUtil;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlay {

    public static void MusicPlay(String url){
        Clip music = null;
        File f=new File(url);
        try {
            try {
                music =  AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            try {
                music.open(ais);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            music.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
          } catch (IOException e) {
                e.printStackTrace();
         }

    }

}