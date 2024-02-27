package src.main;

import src.entity.Player;
import util.Console;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Player player;

    public KeyHandler(Player player){
        Console.log("a");
        this.player = player;
    }


    public void keyTyped(KeyEvent e) {

    }//


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            player.keys[0] = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_X) {
            player.keys[1] = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            player.keys[2] = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            player.keys[3] = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            player.keys[0] = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_X) {
            player.keys[1] = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            player.keys[2] = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            player.keys[3] = false;
        }
    }
}