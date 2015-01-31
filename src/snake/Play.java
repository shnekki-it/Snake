/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.audio.AudioPlayer;

/**
 *
 * @author Timi2
 */

public class Play extends JFrame   {

    private Panel p;
    final Spieler spieler;
    final Background bg;
    
    /*
    Frame für das Snake Spiel
    */
    public Play(Spieler spieler, Background bg){
        super("Snake");
        p = new Panel();
        p.setBounds(0, 0, 1000, 1000);
        add(p);
        addKeyListener(new Keyboard()); // Instanz von Keyboard erstellen
        this.spieler = spieler;
        this.bg = bg;
    }
    //    @Override
    public void repaintPanel(){
         p.repaint();
    }
    
    private class Panel extends JLabel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg.getLook(), (int) bg.get_fposx(),0,null);
        g.drawImage(spieler.getLook(), spieler.getViereck().x, spieler.getViereck().y, null);
//        g.fillRect(spieler.getViereck().x,spieler.getViereck().y,spieler.getViereck().width,spieler.getViereck().height);
//        g.fillOval(spieler.getViereck().x,spieler.getViereck().y,spieler.getViereck().width,spieler.getViereck().height);
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Spieler s = new Spieler(300,300,1000,1000);
        Background bg = new Background(700f,1000,1000,1000);
        Play p = new Play(s,bg);
        p.setSize(1000, 1000);
        p.setResizable(false);
//        s.setUndecorated(true);
        p.setVisible(true);
//        DisplayMode displaymode = new DisplayMode(800, 600, 16, 75);
//        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment().getLocalGraphicsEnvironment();
//        GraphicsDevice device = environment.getDefaultScreenDevice();
//        device.setFullScreenWindow(s);
//        device.setDisplayMode(displaymode);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        long lastFrame = System.currentTimeMillis();
        while(true){
            long thisFrame = System.currentTimeMillis();
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
            lastFrame = thisFrame;
            s.update(timeSinceLastFrame);
            p.repaintPanel();
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){System.out.println(e);}
        }
    }
   
}
