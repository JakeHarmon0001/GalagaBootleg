/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jakeharmon
 */
public class Bullet extends MovingGameObject {
    
    protected int diameter;
    
    public Bullet(int xPos, int yPos, int xVelocity, int yVelocity, int diameter, Color color) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.diameter = diameter;
        this.color = color;
        
    }
    
    public Bullet() {
        xPos = 50;
        yPos = 50;
        xVelocity = 0;
        yVelocity = 10;
        diameter = 20;
        color = Color.GRAY;
    }

    @Override
    public Rectangle getBounds() {
       Rectangle r = new Rectangle(xPos, yPos, 20, 5);
       
       return r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos, yPos+7, diameter, diameter );
        //g.fillRect(xPos, yPos + 5, 10 + 1, diameter );
    }
    
    @Override
    public void move() {
        if(xVelocity > 0) {
            xPos += xVelocity;
        }
        if(xVelocity < 0) {
            xPos += xVelocity;
        }
        if(yVelocity > 0) {
            yPos += yVelocity;
        }
        if(yVelocity < 0) {
            yPos += yVelocity;
        }
    }
    
    
}
