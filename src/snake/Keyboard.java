/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Timi2
 */
public class Keyboard implements KeyListener {

    private static boolean[] keys = new boolean[512];
    
    public static boolean keyisPressed(int keyCode){
        if(keyCode >= 0 && keyCode < keys.length){
            return keys[keyCode];
        }else return false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
         int keycode = e.getKeyCode();
         if(keycode >=0 && keycode<keys.length){
             keys[keycode] = true;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
         if(keycode >=0 && keycode<keys.length){
             keys[keycode] = false;
         }
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
