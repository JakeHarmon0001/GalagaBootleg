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
public class Enemy extends MovingGameObject {
    
    public Enemy(int xPos, int yPos, int xVelocity, int yVelocity, Color color) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
    }
    
    public Enemy() {
        xPos = 100;
        yPos = 100;
        xVelocity = 2;
        yVelocity = 0;
        color = Color.DARK_GRAY;
    }
    
    // create methods that determine when an enemy should move and how they should move
    @Override
    public void move() {
        
        if(xVelocity > 0) {
            xPos += xVelocity;
        }
        if(xVelocity < 0) {
            xPos += xVelocity;
        }
        if(xPos >= 578) {
             yPos += 12;
             xVelocity = -2;
            
        }
        if(xPos <= 22) {
            yPos += 12;
            xVelocity = 2;
        }
        
        
        //checks for collison with ceiling and bottom limit
        
        if(yVelocity > 0) {
            yPos += yVelocity;
        }
        if(yVelocity < 0) {
            yPos += yVelocity;
        }
        if(yPos >= 400) {
            yVelocity = -xVelocity;
        }
        if(yPos <= 0) {
            yVelocity = 1;
        }
        
        
   
    }
    
    public void checkForCollision(Enemy enemy) {
        
        Rectangle r1 = getBounds();
        Rectangle r2 = enemy.getBounds();
        if(r1.intersects(r2)) {
        if(yVelocity > 0) {
            yVelocity = -2;
        }
        else if(yVelocity < 0) {
            yVelocity = 2;
        }
        
        if(xVelocity > 0) {
            xVelocity = -2;
        }
        else if(xVelocity < 0) {
            xVelocity = 2;
        }
        }
    }
    
    public boolean checkForBeamCollsion(Beam beam) {
        
        Rectangle r1 = getBounds();
        Rectangle r2 = beam.getBounds();
        
        if(r1.intersects(r2)){
            beam.setXpos(6000);
            setXpos(6000);
            setXvelocity(0);
            setYvelocity(0);
            return true;
        }
        else {
            return false;
         }
        
        
        
    }
   

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(xPos, yPos,22, 25);
        return r;
        
    }

    @Override
    public void draw(Graphics g) {
        // left wing of tie fighter
        g.setColor(color);
        g.fillRect(xPos, yPos, 4, 25);
        g.setColor(Color.lightGray);
        g.drawRect(xPos, yPos, 4, 25);
        
        //middle of tie fighter
        g.setColor(color);
        g.fillRect(xPos + 4, yPos + 12, 18, 3);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(xPos + 4, yPos + 12,18, 3);
        g.setColor(color);
        g.fillOval( xPos + 8, yPos + 9, 10, 10);
        g.setColor(Color.LIGHT_GRAY);
        g.drawOval(xPos + 8, yPos + 9, 10, 10);
        
        //right wing of tie fighter
        
        g.setColor(color);
        g.fillRect(xPos + 22, yPos, 4, 25);
        g.setColor(Color.lightGray);
        g.drawRect(xPos + 22, yPos, 4, 25);
        
    }
    
    
}
