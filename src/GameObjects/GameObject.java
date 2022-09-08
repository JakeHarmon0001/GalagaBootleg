/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Interfaces.Drawable;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author jakeharmon
 */
public abstract class GameObject implements Drawable {

    protected int xPos;
    protected int yPos;
    protected Color color;

    public GameObject(int xPos, int yPos, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public GameObject() {
        xPos = 50;
        yPos = 50;
        color = Color.BLUE;
    }

    public abstract Rectangle getBounds();

    public int getXpos() {
        return xPos;
    }

    public int getYpos() {
        return yPos;
    }

    public Color getColor() {
        return color;
    }

    public void setXpos(int xPos) {
        this.xPos = xPos;
    }

    public void setYpos(int yPos) {
        this.yPos = yPos;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isColliding(GameObject other) {

        Rectangle r1 = this.getBounds();

        Rectangle r2 = other.getBounds();

        Boolean b = r2.intersects(r1);

        return b;
    }

}
