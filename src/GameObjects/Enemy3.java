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
public class Enemy3 extends MovingGameObject {
    
    protected int hitsToDestroy;
    public Enemy3(int xPos, int yPos, int xVelocity, int yVelocity, Color color) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.color = color;
        hitsToDestroy = 2;
    }
    
    public Enemy3() {
        xPos = 100;
        yPos = 100;
        xVelocity = 1;
        yVelocity = 0;
        color = Color.LIGHT_GRAY;
        hitsToDestroy = 2;
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
        if(yPos >= 500) {
            yVelocity = 1;
        }
        if(yPos <= 0) {
            yVelocity = 1;
        }
   
        //increases speed the further it goes down the screen
        
        
    }
    
    public void checkForCollision(Enemy3 enemy) {
        
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
        Rectangle r = new Rectangle(xPos, yPos - 6,24, 28);
        return r;
        
    }

    @Override
    public void draw(Graphics g) {
        
        
        //left wing of tie bomber
        if(hitsToDestroy == 1) {
            color = Color.red;
        }
        g.setColor(color);
        g.fillRect(xPos, yPos, 4, 16);
        //slanted tips
        Polygon p = new Polygon();
        p.addPoint(xPos, yPos);
        p.addPoint(xPos + 4, yPos);
        p.addPoint(xPos + 10, yPos - 6 );
        p.addPoint(xPos + 6, yPos - 6);
        g.fillPolygon(p);
        Polygon p2 = new Polygon();
        p2.addPoint(xPos, yPos + 16);
        p2.addPoint(xPos + 4, yPos + 16);
        p2.addPoint(xPos + 10, yPos + 22);
        p2.addPoint(xPos + 6, yPos + 22);
        g.fillPolygon(p2);
        
        // middle of ship
        g.fillRect(xPos + 4, yPos + 6, 20, 4);
        g.fillOval(xPos + 8, yPos + 2, 12, 12);
        g.setColor(Color.DARK_GRAY);
        g.drawOval(xPos + 8, yPos + 2, 12, 12);
        g.fillOval(xPos + 10, yPos + 4, 8, 8);
        
        
        //right wing of tie bomber
        if(hitsToDestroy == 2) {
        g.setColor(color);
        g.fillRect(xPos + 24, yPos, 4, 16);
        //slanted tips
        Polygon p3 = new Polygon();
        p3.addPoint(xPos + 24, yPos);
        p3.addPoint(xPos + 28, yPos);
        p3.addPoint(xPos + 22, yPos - 6);
        p3.addPoint(xPos + 18, yPos - 6 );
        
        g.fillPolygon(p3);
        Polygon p4 = new Polygon();
        p4.addPoint(xPos + 24, yPos + 16);
        p4.addPoint(xPos + 28, yPos + 16);
        p4.addPoint(xPos + 22, yPos + 22);
        p4.addPoint(xPos + 18, yPos + 22);
        g.fillPolygon(p4);
        }
        
        
    }
    
    
}
