package jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrlimour
 */
public class PlaySound {
    private java.applet.AudioClip son;
    
    PlaySound(String sound) {
        java.net.URL url= PlaySound.class.getResource(sound);
        son = java.applet.Applet.newAudioClip(url);
        son.play();
    }
    
}

