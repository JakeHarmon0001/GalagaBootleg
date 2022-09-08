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
public class Shield extends GameObject{
    
    protected int height;
    protected int width;
    
    public Shield(int xPos, int yPos, int height, int width,Color color) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    
    public Shield() {
        xPos = 10;
        yPos = 550;
        height = 8;
        width = 10;
        color = Color.white;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(xPos, yPos, width, height);
        return r;
    }            

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
        
    }
    
    
    
}
