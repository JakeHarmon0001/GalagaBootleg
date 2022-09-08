/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import Interfaces.Moveable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jakeharmon
 */
public abstract class ControlledGameObject extends GameObject implements Moveable {

    protected KeyboardController control;

    public ControlledGameObject(int xPos, int yPos, Color color, KeyboardController control) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.control = control;

    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        
    }

}
