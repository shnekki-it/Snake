/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Timi2
 */
public class Spieler {
    //Var
    private float f_posx;
    private float f_posy;
    private int i_worldsize_x;
    private int i_worldsize_y;
    private Rectangle viereck;
    private BufferedImage look;
    private Raster r = null;
    private Keyboard k;
    //Konstr
    public Spieler(int x, int y, int worldsize_x, int worldsize_y){
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("graphic/pac.png"));
        } catch (IOException ex) { Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);}
        viereck = new Rectangle(x,y,getLook().getWidth(),getLook().getHeight());
        f_posx = x;
        f_posy = y;
        i_worldsize_x = worldsize_x;
        i_worldsize_y = worldsize_y;
    }
    public void update(float time){
        if(Keyboard.keyisPressed(KeyEvent.VK_W))
            f_posy -= 300*time;
        if(Keyboard.keyisPressed(KeyEvent.VK_S))
            f_posy += 300*time;
        if(Keyboard.keyisPressed(KeyEvent.VK_A))
            f_posx -= 300*time;
        if(Keyboard.keyisPressed(KeyEvent.VK_D))
            f_posx += 300*time;
        viereck.x = (int)f_posx;
        viereck.y = (int)f_posy;
        // Randerkennung
        if(f_posx > i_worldsize_x-getViereck().width)f_posx = 0;
        if(f_posx < 0)f_posx = i_worldsize_x-getViereck().width;
        if(f_posy > i_worldsize_y-getViereck().height)f_posy = 0;
        if(f_posy < 0)f_posy = i_worldsize_y-getViereck().height;
    }
    /**
     * @return the f_posx
     */
    public float getF_posx() {
        return f_posx;
    }
    /**
     * @param f_posx the f_posx to set
     */
    public void setF_posx(float f_posx) {
        this.f_posx = f_posx;
    }
    /**
     * @return the f_posy
     */
    public float getF_posy() {
        return f_posy;
    }
    /**
     * @param f_posy the f_posy to set
     */
    public void setF_posy(float f_posy) {
        this.f_posy = f_posy;
    }
    /**
     * @return the viereck
     */
    public Rectangle getViereck() {
        return viereck;
    }
    /**
     * @param viereck the viereck to set
     */
    public void setViereck(Rectangle viereck) {
        this.viereck = viereck;
    }

    /**
     * @return the look
     */
    public BufferedImage getLook() {
        return look;
    }

    /**
     * @return the r
     */
    public Raster getR() {
        return r;
    }
}
