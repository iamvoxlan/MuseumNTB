
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author voXlan
 */
public class PlaySound implements LineListener{
    
    boolean playCompleted = false;
    
    public void PlayMusic(String filePath){
        File soundFile = new File(filePath);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
            while (!playCompleted) {                
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            audioClip.close();
            audioStream.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(LineEvent arg0) {
        LineEvent.Type type = arg0.getType();
        
        if (type == LineEvent.Type.STOP){
            playCompleted = true;
        }
    }
    
}
