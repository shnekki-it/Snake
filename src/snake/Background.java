/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Timi2
 */
public class Background {
    private float f_posx;
    private float f_speed;
    private BufferedImage look;
    
    public Background(float speed, int height, int width, int ints){
            try {
                look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphic/Universum.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void update(float timesincelastframe){
        
    }
    /**
     * @return the f_posx
     */
    public float get_fposx() {
        return f_posx;
    }
    /**
     * @return the look
     */
    public BufferedImage getLook() {
        return look;
    }
}
