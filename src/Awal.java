

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Awal {
       public static void main(String[] args) {
           ProgressBar progressBar = new ProgressBar();
           MP3Player mp3Player = new MP3Player(new File("C:\\Users\\voXlan\\Documents\\NetBeansProjects\\Daftar Pengunjung Museum\\src\\sound\\intro.mp3"));
           progressBar.setVisible(true);
            progressBar.setLocationRelativeTo(null);
            mp3Player.play();
            try{
                for(int i =0;i<=100;i++){
                    Thread.sleep(40);
                   progressBar.Progress_Bar.setValue(i);
                     if(i==100){
                      Thread.sleep(210);
                      progressBar.dispose();
                      LoginPage loginPage = new LoginPage();
                      loginPage.setVisible(true);
                      loginPage.setLocationRelativeTo(null);
                      mp3Player.stop();
                     }

                }
            }
            catch(Exception ex){
            }
    }
}
