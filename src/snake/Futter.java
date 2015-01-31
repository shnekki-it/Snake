/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Timi2
 */
public class Futter {
    private float f_posx;
    private float f_posy;
    private Rectangle viereck;
    BufferedImage fu;
    public Futter(int x, int y){
        this.f_posx = x;
        this.f_posy = y;
        try {
            fu = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphic/futter.png"));
        } catch (IOException ex) {
            Logger.getLogger(Futter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
