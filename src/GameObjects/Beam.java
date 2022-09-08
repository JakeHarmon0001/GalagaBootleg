/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 *
 * @author jakeharmon
 */
public class Beam extends MovingGameObject {
    
    protected int height;
    protected int width;

    public Beam(int xPos, int yPos, int xVelocity, int yVelocity, int height, int width, Color color) {
       
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity =xVelocity;
        this.yVelocity = yVelocity;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    
    public Beam() {
        
        xPos = 50;
        yPos = 50;
        xVelocity = 0;
        yVelocity = -10;
        height = 20;
        width = 5;
        color = Color.RED;
    }
    
    
    
    //returns a hit box like object
    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(xPos, yPos, 5, 20);
        return r;
    }
    //draws the beam
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);

    }
    
    public boolean checkForCollison(Enemy e) {
        
        if(getBounds().intersects(e.getBounds())) {
            //if you want them to never stop coming set to e.setXpos(-800);
            setXpos(-800);
            return true;
        }
        else {
            return false;
        }
    }
    
    
}
