/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jakeharmon
 */
public class TestFrame extends JFrame {
     public TestFrame() {
        super("My Frame");

        // You can set the content pane of the frame to your custom class.
        setContentPane(new DrawPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true); 
        setBackground(Color.BLACK);
   }

   // Create a component that you can actually draw on.
   class DrawPane extends JPanel {
        public void paintComponent(Graphics g) {
            
            Ship s = new Ship();
            s.draw(g);
        }
   }

   public static void main(String args[]){
        new TestFrame();
   }
}

