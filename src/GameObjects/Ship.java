/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author jakeharmon
 */
public class Ship extends ControlledGameObject {

    protected int highScore;
    protected int model;

    public Ship(int xPos, int yPos, Color color, KeyboardController control) {
        super(xPos, yPos, color, control);
        
        
    }

    public Ship() {
        super(100, 100, Color.yellow, new KeyboardController());
        model = 1;
    }

    

    public void setModel(int model1or2) {
        this.model = model1or2;
    }

    @Override
    public void draw(Graphics g) {

        Color tan = new Color(246, 211, 147);
        Color lightBlue = new Color(30,144,255);
       
        if(control.getLeftKeyStatus() == true) {
                g.setColor(lightBlue);
                g.fillOval(xPos, yPos + 40, 10, 20);
            }
        if(control.getRightKeyStatus() == true) {
                g.setColor(lightBlue);
                g.fillOval(xPos + 30, yPos + 40, 10, 20);
            }
            //draws y-wing
            //left wing of Y-Wing
            g.setColor(Color.white);
            g.fillOval(xPos, yPos - 4, 10, 10);
            g.setColor(Color.lightGray);
            g.drawOval(xPos, yPos - 4, 10, 10);
            g.setColor(color);
            g.fillRect(xPos, yPos, 10, 50);
            g.setColor(Color.LIGHT_GRAY);
            g.drawRect(xPos, yPos, 10, 50);

            //Middle of Y-Wing
            g.setColor(color);
            g.fillRect(xPos + 10, yPos + 6, 20, 8);
            g.setColor(Color.lightGray);
            g.drawRect(xPos + 10, yPos + 6, 20, 8);
            g.setColor(color);
            g.fillRect(xPos + 17, yPos - 12, 6, 18);
            g.setColor(Color.lightGray);
            g.drawRect(xPos + 17, yPos - 12, 6, 18);
            g.setColor(color);
            g.fillRect(xPos + 17, yPos - 26, 6, 18);
            Polygon p = new Polygon();
            p.addPoint(xPos + 9, yPos - 10);
            p.addPoint(xPos + 17, yPos - 10);
            p.addPoint(xPos + 17, yPos - 25);
            g.fillPolygon(p);
            g.setColor(color);
            Polygon p2 = new Polygon();
            p2.addPoint(xPos + 30, yPos - 10);
            p2.addPoint(xPos + 23, yPos - 10);
            p2.addPoint(xPos + 23, yPos - 25);
            g.fillPolygon(p2);

            //outline of middle 
            Polygon p3 = new Polygon();
            p3.addPoint(xPos + 30, yPos - 10);
            p3.addPoint(xPos + 23, yPos - 25);
            p3.addPoint(xPos + 17, yPos - 25);
            p3.addPoint(xPos + 9, yPos - 10);

            g.setColor(Color.lightGray);
            g.drawPolygon(p3);
            g.setColor(color);
            g.fillRect(xPos + 17, yPos - 24, 6, 18);
            g.setColor(Color.white);
            g.fillRect(xPos + 17, yPos - 24, 6, 12);
            g.setColor(Color.BLACK);
            g.drawRect(xPos + 17, yPos - 24, 6, 12);

            //right wing of Y-Wing
            g.setColor(Color.white);
            g.fillOval(xPos + 30, yPos - 4, 10, 10);
            g.setColor(color);
            g.drawOval(xPos + 30, yPos - 4, 10, 10);
            g.setColor(color);
            g.fillRect(xPos + 30, yPos, 10, 50);
            g.setColor(Color.lightGray);
            g.drawRect(xPos + 30, yPos, 10, 50);
            
            //drawing smaller details 
            g.setColor(Color.black);
            g.fillRect(xPos + 1, yPos + 14, 8, 32);
            g.fillRect(xPos + 31, yPos + 14, 8, 32);
            
            

    }

    @Override
    public void move() {

        if (control.getLeftKeyStatus() == true) {
            setXpos(this.xPos -= 5);
        } else if (control.getRightKeyStatus() == true) {
            setXpos(this.xPos += 5);
        }

        if (xPos < 0) {
            xPos = 0;
        }
        if (xPos > 560) {
            xPos = 560;
        }

    }

  
    public Beam drawBeam() {
        Beam temp = new Beam();

        temp.setXpos(this.getXpos());
        temp.setYpos(this.getYpos());
        temp.setXvelocity(0);
        temp.setYvelocity(5);
        temp.setColor(Color.red);

        return temp;

    }

    @Override
    public Rectangle getBounds() {

        Rectangle r = new Rectangle(xPos, yPos - 24, 30, 64);
        return r;
    }

    public boolean checkForCollsionBullet(Bullet b) {
        if (getBounds().intersects(b.getBounds())) {
            return true;
        } else {
            return false;
        }
    }
}
