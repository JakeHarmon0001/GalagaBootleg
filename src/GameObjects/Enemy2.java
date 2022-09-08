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
public class Enemy2 extends MovingGameObject {
    
    protected int hitsToDestroy;
    public Enemy2(int xPos, int yPos, int xVelocity, int yVelocity, Color color) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
        hitsToDestroy = 2;
    }
    
    public Enemy2() {
        xPos = 100;
        yPos = 100;
        xVelocity = 1;
        yVelocity = 0;
        color = Color.DARK_GRAY;
        hitsToDestroy = 4;
    }
    
    public int getHitsToDestroy() {
        return hitsToDestroy;
    }
    
    public void setHitsToDestroy(int hits) {
        this.hitsToDestroy = hits;
    }
    
    // create methods that determine when an enemy should move and how they should move
    @Override
    public void move() {
        
        //checks for change in velocity and checks for collison with walls
        
        if(xVelocity > 0) {
            xPos += xVelocity;
        }
        if(xVelocity < 0) {
            xPos += xVelocity;
        }
        if(xPos >= 578) {
             yPos += 20;
             xVelocity = -xVelocity;
            
        }
        if(xPos <= 22) {
            yPos += 20;
            xVelocity = 1;
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
   
        //increases speed the further it goes down the screen
        
        
    }
    
    public void checkForCollision(Enemy2 enemy) {
        
        Rectangle r1 = getBounds();
        Rectangle r2 = enemy.getBounds();
        if(r1.intersects(r2)) {
        if(yVelocity > 0) {
            yVelocity = -2;
        }
        else if(yVelocity < 0) {
            yVelocity = 1;
        }
        
        if(xVelocity > 0) {
            xVelocity = -1;
        }
        else if(xVelocity < 0) {
            xVelocity = 1;
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
        Color lightBlue = new Color(30,144,255);
        if(hitsToDestroy == 4) {
            g.setColor(lightBlue);
            g.fillOval(xPos + 5, yPos - 12, 10, 15);
            g.fillOval(xPos + 15, yPos - 12, 10, 15);
        }
        //main segment of star destroyer
        Polygon p = new Polygon();
        p.addPoint(xPos + 20, yPos - 5);
        p.addPoint(xPos + 10, yPos - 5);
        p.addPoint(xPos, yPos);
        p.addPoint(xPos + 15, yPos + 50);
        p.addPoint(xPos +  30, yPos);
        g.setColor(Color.LIGHT_GRAY);
        if(hitsToDestroy == 3) {
            g.setColor(Color.yellow);
        }
        if(hitsToDestroy == 2){
            g.setColor(Color.ORANGE);
        }
        if(hitsToDestroy == 1) {
            g.setColor(Color.red);
        }
        g.fillPolygon(p);
        g.setColor(Color.DARK_GRAY);
        g.drawPolygon(p);
        g.setColor(Color.white);
        g.fillRect( xPos + 5, yPos + 3, 20, 8);
        g.setColor(Color.black);
        g.drawRect(xPos + 5, yPos + 3, 20, 8);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(xPos + 15, yPos + 12, xPos + 15, yPos + 50);
        
    }
    
    
}
