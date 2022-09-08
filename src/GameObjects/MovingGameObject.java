/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Interfaces.Moveable;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author jakeharmon
 */
public abstract class MovingGameObject extends GameObject implements Moveable {

    protected int xVelocity;
    protected int yVelocity;

    public MovingGameObject(int xPos, int yPos, int xVelocity, int yVelocity, Color color) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
    }

    public MovingGameObject() {

        xPos = 50;
        yPos = 50;
        xVelocity = 10;
        yVelocity = 10;
        color = Color.red;
    }

    public int getXvelocity() {
        return xVelocity;
    }

    public int getYvelocity() {
        return yVelocity;
    }

    public void setXvelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYvelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    @Override
    public void move() {

        if (xVelocity < 0) {
            xPos += xVelocity;
        }
        if (yVelocity < 0) {
            yPos += yVelocity;
        }

    }
    
    
}
